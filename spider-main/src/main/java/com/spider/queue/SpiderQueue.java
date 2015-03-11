package com.spider.queue;

import java.util.LinkedList;


public class SpiderQueue {


	private static LinkedList<String> pageInfos = new LinkedList<String>();

	public synchronized String poll() {
		return pageInfos.poll();
	}

	public synchronized boolean offer(String pageInfo) {
		return pageInfos.offer(pageInfo);
	}


}
