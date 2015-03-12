package com.spider.utils;

import java.io.IOException;

public class HtmlPageInfo {

	public static String catchPageInfo(String url) {
		String pageInfo = "";
		try {
			pageInfo = WebUtils.doGet(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageInfo;
	}

}
