package com.spider.handle;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.spider.HtmlAnalyzeHandle;
import com.spider.domain.Item;
import com.spider.utils.WebUtils;

public class HrefHandle implements HtmlAnalyzeHandle {
	private static Set<String> urls = new HashSet<String>();

	@Override
	public Item analyze(String html) {
		try {
			String pageInfo = WebUtils.doGet("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
