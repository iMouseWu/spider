package com.spider.queue;

import java.util.LinkedList;

public class PageUrlQueue {

	private static LinkedList<String> urls = new LinkedList<String>();

	public synchronized String poll() {
		return urls.poll();
	}

	public synchronized boolean offer(String url) {
		return urls.offer(url);
	}

}
