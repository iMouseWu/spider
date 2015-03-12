package com.spider.queue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * URL分分析处理类。主要功能包括URL的去重。URL的辨别
 * 
 * @author wuhao
 */
public class ItemUrlQueue {

	public static Set<String> urls = new HashSet<String>();

	public synchronized String getUrl() {
		Iterator<String> iterator = urls.iterator();
		String url = iterator.next();
		urls.remove(url);
		return url;
	}

	public synchronized boolean addUrl(String url) {
		return urls.add(url);
	}
}
