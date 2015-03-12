package com.spider.filter.url;

import com.spider.filter.SpiderFilter;
import com.spider.queue.PageUrlQueue;

public class PageUrlFilter implements SpiderFilter {

	private SpiderFilter next;

	public void setNext(SpiderFilter next) {
		this.next = next;
	}

	@Override
	public void filter(FilterContext filterContext) {
		PageUrlQueue pageUrlQueue = new PageUrlQueue();
		pageUrlQueue.offer(filterContext.getUrl());

		next.filter(filterContext);
	}

}
