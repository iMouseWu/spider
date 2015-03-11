package com.spider.info;

import java.io.IOException;

import com.spider.queue.WebPageQueue;
import com.spider.queue.WebUrlQueue;
import com.spider.utils.WebUtils;

public class ItemPageInfo {

	private String catchPageInfo(String url) {
		String pageInfo = "";
		try {
			pageInfo = WebUtils.doGet(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageInfo;
	}

	public void catchInfoPutInQueue() {
		WebUrlQueue webUrlHandle = new WebUrlQueue();
		String pageInfo = catchPageInfo(webUrlHandle.getUrl());

		WebPageQueue webPageQueue = new WebPageQueue();
		webPageQueue.offer(pageInfo);
	}
}
