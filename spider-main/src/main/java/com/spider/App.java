package com.spider;

import com.spider.info.ItemPageInfo;
import com.spider.queue.WebPageQueue;
import com.spider.queue.WebUrlQueue;

public class App {

	public static void main(String[] args) {
		WebUrlQueue weburls = new WebUrlQueue();
		weburls.addUrl("http://item.taobao.com/item.htm?id=41229160193");

		ItemPageInfo pageInfo = new ItemPageInfo();
		pageInfo.catchInfoPutInQueue();

		WebPageQueue queue = new WebPageQueue();
		System.out.println(queue.poll());
	}

}
