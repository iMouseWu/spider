package com.spider.filter;

public interface SpiderFilter {

	void setNext(SpiderFilter next);

	void filter(Context context);

}
