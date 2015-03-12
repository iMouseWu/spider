package com.spider.handle;

import java.util.List;

import com.spider.HtmlAnalyze;
import com.spider.SpiderHandle;
import com.spider.analyze.HrefAnalyze;
import com.spider.domain.PageUrlDO;
import com.spider.exception.SpiderQueueException;
import com.spider.filter.FilterContext;
import com.spider.filter.SpiderFilter;
import com.spider.filter.url.ItemUrlFilter;
import com.spider.filter.url.PageUrlFilter;
import com.spider.filter.url.RightFilter;
import com.spider.filter.url.UrlContainFilter;
import com.spider.queue.PageUrlDoingQueue;
import com.spider.queue.PageUrlQueue;
import com.spider.utils.HtmlPageInfo;

public class UrlPageHandle implements SpiderHandle {

	private HtmlAnalyze htmlAnalyze;

	public void setHtmlAnalyze(HtmlAnalyze htmlAnalyze) {
		this.htmlAnalyze = htmlAnalyze;
	}

	public void handle() throws SpiderQueueException {
		PageUrlQueue pageUrlQueue = PageUrlQueue.getInstance();

		PageUrlDO pageUrl = null;
		pageUrl = pageUrlQueue.pollAndAddTaskQueue();

		String shopId = pageUrl.getShopId();
		String url = pageUrl.getUrl();

		String html = HtmlPageInfo.catchPageInfo(url);

		htmlAnalyze.analyze(html);
		if (htmlAnalyze instanceof HrefAnalyze) {
			List<String> hrefs = ((HrefAnalyze) htmlAnalyze).getHrefs();
			for (String href : hrefs) {
				FilterContext context = new FilterContext();
				context.setShopId(shopId);
				context.setUrl(href);
				createFilterChain().filter(context);
			}
		}
		PageUrlDoingQueue.getInstance().remove(shopId, url);
	}

	private SpiderFilter createFilterChain() {
		SpiderFilter rightFilter = new RightFilter();

		SpiderFilter urlContainFilter = new UrlContainFilter();
		rightFilter.setNext(urlContainFilter);
		SpiderFilter iItemUrlFilter = new ItemUrlFilter();
		urlContainFilter.setNext(iItemUrlFilter);
		SpiderFilter pageUrlFilter = new PageUrlFilter();
		iItemUrlFilter.setNext(pageUrlFilter);

		return rightFilter;
	}

}
