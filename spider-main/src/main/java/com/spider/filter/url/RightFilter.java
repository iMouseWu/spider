package com.spider.filter.url;

import com.spider.filter.SpiderFilter;

public class RightFilter implements SpiderFilter {

	private SpiderFilter next;

	public void setNext(SpiderFilter next) {
		this.next = next;
	}

	@Override
	public void filter(FilterContext filterContext) {
		// TODO Auto-generated method stub

		next.filter(filterContext);
	}

}
