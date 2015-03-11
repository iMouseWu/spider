package com.spider;

import com.spider.handle.WebUrlHandle;
import com.spider.info.PageInfo;
import com.spider.utils.WebPageQueue;

public class App {

	public static void main(String[] args) {
		WebUrlHandle weburls = new WebUrlHandle();
		weburls.addUrl("http://item.taobao.com/item.htm?id=41229160193");

		PageInfo pageInfo = new PageInfo();
		pageInfo.catchInfoPutInQueue();

		WebPageQueue queue = new WebPageQueue();
		System.out.println(queue.poll());
	}

}
