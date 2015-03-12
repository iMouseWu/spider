package com.spider.filter.url;

import com.spider.filter.Context;
import com.spider.filter.SpiderFilter;
import com.spider.queue.ItemUrlQueue;

public class ItemUrlFilter implements SpiderFilter {

	private SpiderFilter next;

	public void setNext(SpiderFilter next) {
		this.next = next;
	}

	@Override
	public void filter(Context filterContext) {
		ItemUrlQueue itemUrlQueue = new ItemUrlQueue();
		itemUrlQueue.addUrl(filterContext.getUrl());
		next.filter(filterContext);
	}

}
