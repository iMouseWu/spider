package com.spider.queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

public class PageUrlDoingQueue {

	private static PageUrlDoingQueue queue = new PageUrlDoingQueue();

	/**
	 * Map<ShopId,urlSet>
	 */
	private Map<String, List<String>> urlInfos = new HashMap<String, List<String>>();

	private PageUrlDoingQueue(){

	}

	public static PageUrlDoingQueue getInstance() {
		return queue;

	}

	public synchronized void putHasDingUrl(String shopId, String url) {

		List<String> urls = urlInfos.get(shopId);
		if (CollectionUtils.isEmpty(urls)) {
			urls = new ArrayList<String>();
		}
		urls.add(url);
		urlInfos.put(shopId, urls);
	}

	public synchronized boolean remove(String shopId, String url) {
		return urlInfos.get(shopId).remove(url);
	}

	public synchronized void remove(String shopId) {
		urlInfos.remove(shopId);
	}

	public synchronized boolean isHasTask(String shopId) {
		return CollectionUtils.isNotEmpty(urlInfos.get(shopId));
	}
}
