package com.spider.queue;

import java.util.LinkedList;

/**
 * 单个商品详情页面
 * 
 * @author wuhao
 */
public class ItemPageQueue {

	private static LinkedList<String> pageInfos = new LinkedList<String>();

	public synchronized String poll() {
		return pageInfos.poll();
	}

	public synchronized boolean offer(String pageInfo) {
		return pageInfos.offer(pageInfo);
	}

}
