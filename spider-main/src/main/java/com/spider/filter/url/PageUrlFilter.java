package com.spider.filter.url;

import com.spider.domain.PageUrlDO;
import com.spider.filter.Context;
import com.spider.filter.FilterContext;
import com.spider.filter.SpiderFilter;
import com.spider.queue.PageUrlQueue;

public class PageUrlFilter implements SpiderFilter {

	private SpiderFilter next;

	public void setNext(SpiderFilter next) {
		this.next = next;
	}

	@Override
	public void filter(Context context) {
		PageUrlQueue pageUrlQueue = PageUrlQueue.getInstance();

		if (!(context instanceof FilterContext)) {
			throw new IllegalArgumentException("context type error.what wo want is FilterContext");
		}
		FilterContext filterContext = (FilterContext) context;

		PageUrlDO pageUrlDO = new PageUrlDO();
		pageUrlDO.setShopId(filterContext.getShopId());
		pageUrlDO.setUrl(filterContext.getUrl());
		pageUrlQueue.offer(pageUrlDO);

		next.filter(filterContext);
	}
}
