package com.spider.thread;

import com.spider.HtmlAnalyze;
import com.spider.SpiderCleaner;
import com.spider.analyze.HrefAnalyze;
import com.spider.exception.SpiderQueueException;
import com.spider.handle.UrlPageHandle;
import com.spider.queue.PageUrlDoingQueue;
import com.spider.queue.PageUrlQueue;

public class ServiceThread implements Runnable {

	private int threadCount = 10;
	private String shopId;
	private SpiderCleaner spiderCleaner;

	public void setSpiderCleaner(SpiderCleaner spiderCleaner) {
		this.spiderCleaner = spiderCleaner;
	}

	public ServiceThread(int threadCount, String shopId){
		this.threadCount = threadCount;
		this.shopId = shopId;
	}

	@Override
	public void run() {

		UrlPageHandle urlPageHandle = new UrlPageHandle();
		while (true) {
			if (!isHasUnDoUrl(shopId)) {
				synchronized (this) {
					threadCount--;
				}

				return;
			}

			HtmlAnalyze htmlAnalyze = new HrefAnalyze();
			urlPageHandle.setHtmlAnalyze(htmlAnalyze);

			try {
				urlPageHandle.handle();
			} catch (SpiderQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private boolean isHasUnDoUrl(String shopId) {
		return PageUrlDoingQueue.getInstance().isHasTask(shopId) || PageUrlQueue.getInstance().isHasUnDoUrl(shopId);
	}

	public void startServiceThread() {
		for (int i = 0; i < threadCount; i++) {
			Thread thread = new Thread(this);
			thread.start();
		}
		while (true) {
			if (threadCount == 0) {
				spiderCleaner.clean();
				return;
			}
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
