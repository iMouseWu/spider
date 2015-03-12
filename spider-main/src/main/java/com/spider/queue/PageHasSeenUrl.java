package com.spider.queue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

/**
 * 页面爬过的URL汇总。可以配置一个过滤器来过滤一些不是需要爬的网页
 * 
 * @author wuhao
 */
public class PageHasSeenUrl {

	private static PageHasSeenUrl pageHasSeenUrl = new PageHasSeenUrl();

	private PageHasSeenUrl(){

	}

	public static PageHasSeenUrl getInstance() {
		return pageHasSeenUrl;
	}

	/**
	 * Map<ShopId,urlSet>
	 */
	private Map<String, Set<String>> pageInfos = new HashMap<String, Set<String>>();

	public synchronized boolean isUrlContain(String shopId, String url) {
		Set<String> set = pageInfos.get(shopId);
		if (CollectionUtils.isEmpty(set)) {
			return true;
		}
		return set.contains(url);
	}

	public synchronized void putUrl(String shopId, String url) {
		Set<String> set = pageInfos.get(shopId);
		if (CollectionUtils.isEmpty(set)) {
			set = new HashSet<String>();
		}
		set.add(url);
		pageInfos.put(shopId, set);
	}

	/**
	 * FIXME 这个方法是否需要同步
	 */
	public void remove(String shopId) {
		pageInfos.remove(shopId);
	}

}
