package com.spider.filter.url;

import java.util.Set;

import com.spider.filter.SpiderFilter;
import com.spider.queue.PageHasSeenUrl;

public class UrlContainFilter implements SpiderFilter {

	private SpiderFilter next;

	public void setNext(SpiderFilter next) {
		this.next = next;
	}

	@Override
	public void filter(FilterContext filterContext) {
		PageHasSeenUrl pageHasSeenUrl = new PageHasSeenUrl();
		if (pageHasSeenUrl.isUrlContain(filterContext.getShopId(), filterContext.getUrl())) {
			return;
		} else {
			pageHasSeenUrl.putUrl(filterContext.getShopId(), filterContext.getUrl());
			next.filter(filterContext);
		}

	}

}
