package com.spider.cleaner;

import com.spider.SpiderCleaner;
import com.spider.queue.PageHasSeenUrl;
import com.spider.queue.PageUrlDoingQueue;
import com.spider.queue.PageUrlQueue;

public class PageUrlCleaner implements SpiderCleaner {

	private String shopId;

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	@Override
	public void clean() {
		PageHasSeenUrl.getInstance().remove(shopId);
		PageUrlDoingQueue.getInstance().remove(shopId);
		PageUrlQueue.getInstance().remove(shopId);
	}
}
