package com.spider;

import com.spider.domain.Item;
import com.spider.queue.ItemPageQueue;

public class Client {

	private HtmlAnalyzeHandle htmlAnalyzeHandle;

	public static void main(String[] args) {
		Client client = new Client();

		ItemPageQueue webPageQueue = new ItemPageQueue();
		String html = webPageQueue.poll();

		Item item = client.htmlAnalyzeHandle.analyze(html);

	}

}
