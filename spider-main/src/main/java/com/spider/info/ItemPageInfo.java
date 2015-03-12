package com.spider.info;

import java.io.IOException;

import com.spider.queue.ItemPageQueue;
import com.spider.queue.ItemUrlQueue;
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
		ItemUrlQueue webUrlHandle = new ItemUrlQueue();
		String pageInfo = catchPageInfo(webUrlHandle.getUrl());

		ItemPageQueue webPageQueue = new ItemPageQueue();
		webPageQueue.offer(pageInfo);
	}
}
