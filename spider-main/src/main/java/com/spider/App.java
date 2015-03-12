package com.spider;

import com.spider.info.ItemPageInfo;
import com.spider.queue.ItemPageQueue;
import com.spider.queue.ItemUrlQueue;

public class App {

	public static void main(String[] args) {
		ItemUrlQueue weburls = new ItemUrlQueue();
		weburls.addUrl("http://item.taobao.com/item.htm?id=41229160193");

		ItemPageInfo pageInfo = new ItemPageInfo();
		pageInfo.catchInfoPutInQueue();

		ItemPageQueue queue = new ItemPageQueue();
		System.out.println(queue.poll());
	}

}
