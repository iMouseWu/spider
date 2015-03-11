package com.spider;

import com.spider.domain.Item;
import com.spider.queue.WebPageQueue;

public class Client {

	private HtmlAnalyzeHandle htmlAnalyzeHandle;

	public static void main(String[] args) {
		Client client = new Client();

		WebPageQueue webPageQueue = new WebPageQueue();
		String html = webPageQueue.poll();

		Item item = client.htmlAnalyzeHandle.analyze(html);

	}

}
