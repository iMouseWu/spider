package com.spider.filter.url;

import com.spider.filter.Context;
import com.spider.filter.FilterContext;
import com.spider.filter.SpiderFilter;
import com.spider.queue.PageHasSeenUrl;

public class UrlContainFilter implements SpiderFilter {

	private SpiderFilter next;

	public void setNext(SpiderFilter next) {
		this.next = next;
	}

	@Override
	public void filter(Context context) {
		if (!(context instanceof FilterContext)) {
			throw new IllegalArgumentException("context type error.what wo want is FilterContext");
		}
		FilterContext filterContext = (FilterContext) context;

		PageHasSeenUrl pageHasSeenUrl = PageHasSeenUrl.getInstance();
		if (pageHasSeenUrl.isUrlContain(filterContext.getShopId(), filterContext.getUrl())) {
			return;
		} else {
			pageHasSeenUrl.putUrl(filterContext.getShopId(), filterContext.getUrl());
			next.filter(context);
		}

	}
}
