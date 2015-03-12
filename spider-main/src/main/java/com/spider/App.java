package com.spider;

import com.spider.cleaner.PageUrlCleaner;
import com.spider.domain.PageUrlDO;
import com.spider.queue.PageUrlQueue;
import com.spider.thread.ServiceThread;

public class App {

	private String shopId;

	private String shopUrl;

	public String getShopId() {
		return shopId;
	}

	public String getShopUrl() {
		return shopUrl;
	}

	public App(String shopId, String shopUrl){
		this.shopId = shopId;
		this.shopUrl = shopUrl;
	}

	public App(){
	}

	public void begainService() {
		PageUrlQueue pageUrlQueue = PageUrlQueue.getInstance();

		PageUrlDO pageUrlDO = new PageUrlDO();

		App app = new App();
		final String shopId = app.getShopId();
		final String url = app.getShopUrl();
		pageUrlDO.setShopId(shopId);
		pageUrlDO.setUrl(url);

		pageUrlQueue.offer(pageUrlDO);

		PageUrlCleaner spiderCleaner = new PageUrlCleaner();
		spiderCleaner.setShopId(shopId);
		ServiceThread service = new ServiceThread(10, shopId);
		service.setSpiderCleaner(spiderCleaner);

		service.startServiceThread();
	}

}
