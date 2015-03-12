package com.spider.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;

import com.spider.domain.PageUrlDO;
import com.spider.exception.SpiderQueueException;

public class PageUrlQueue {

	private static PageUrlQueue queue = new PageUrlQueue();
	private Map<String, LinkedList<PageUrlDO>> map = new HashMap<String, LinkedList<PageUrlDO>>();

	private PageUrlQueue(){

	}

	public static PageUrlQueue getInstance() {
		return queue;

	}

	public synchronized void offer(PageUrlDO url) {
		String shopId = url.getShopId();
		LinkedList<PageUrlDO> list = map.get(shopId);
		if (CollectionUtils.isEmpty(list)) {
			list = new LinkedList<PageUrlDO>();
		}
		list.add(url);
		map.put(shopId, list);
	}

	public synchronized boolean isHasUnDoUrl(String shopId) {
		return CollectionUtils.isNotEmpty(map.get(shopId));
	}

	private PageUrlDO poll() {
		for (Entry<String, LinkedList<PageUrlDO>> entry : map.entrySet()) {
			if (CollectionUtils.isNotEmpty(entry.getValue())) {
				return entry.getValue().poll();
			}
		}
		return null;
	}

	public PageUrlDO pollAndAddTaskQueue() throws SpiderQueueException {
		PageUrlDO pageUrl = null;
		try {
			PageUrlDoingQueue pageUrlDoingQueue = PageUrlDoingQueue.getInstance();
			synchronized (pageUrlDoingQueue) {
				try {
					synchronized (this) {
						pageUrl = poll();
						pageUrlDoingQueue.putHasDingUrl(pageUrl.getShopId(), pageUrl.getUrl());
					}
				} catch (Exception e) {
					offer(pageUrl);
					throw new Exception(e);
				}
			}
		} catch (Exception e) {
			throw new SpiderQueueException(e);
		}
		return pageUrl;
	}

	public void remove(String shopId) {
		map.remove(shopId);
	}
}
