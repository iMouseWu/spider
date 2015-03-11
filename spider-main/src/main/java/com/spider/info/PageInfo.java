package com.spider.info;

import java.io.IOException;

import com.spider.handle.WebUrlHandle;
import com.spider.utils.WebPageQueue;
import com.spider.utils.WebUtils;

public class PageInfo {

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
		WebUrlHandle webUrlHandle = new WebUrlHandle();
		String pageInfo = catchPageInfo(webUrlHandle.getUrl());

		WebPageQueue webPageQueue = new WebPageQueue();
		webPageQueue.offer(pageInfo);
	}
}
