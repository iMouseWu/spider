package com.spider.analyze;

import java.util.ArrayList;
import java.util.List;

import com.spider.HtmlAnalyze;

/**
 * 抓取html中的href。该类不支持同步。
 * 
 * @author wuhao
 */
public class HrefAnalyze implements HtmlAnalyze {

	private List<String> hrefs = new ArrayList<String>();

	public List<String> getHrefs() {
		return hrefs;
	}

	@Override
	public void analyze(String html) {

	}

}
