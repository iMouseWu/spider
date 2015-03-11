package com.spider.handle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.spider.HtmlAnalyzeHandle;
import com.spider.domain.Item;

public class TbHtmlHandle implements HtmlAnalyzeHandle {

	@Override
	public Item analyze(String html) {
		String html1 = "price:900.00,bnow:true, prepay:true, dbst:1422416276000,tka:false,chong:false, ju:false, iju: false, cu: false,  fcat:false, auto:\"false\", jbid:\"\",stepdata:{},jmark:\"\",   quickAdd: 1,initSizeJs:true,auctionImages:[\"http://img04.taobaocdn.com/bao/uploaded/i4/49890947/TB25KBEapXXXXawXpXXXXXXXXXX-49890947.jpg\",\"http://img03.taobaocdn.com/bao/uploaded/i3/49890947/TB23tXGapXXXXX4XpXXXXXXXXXX-49890947.jpg\",\"http://img03.taobaocdn.com/bao/uploaded/i3/49890947/TB2sv0HapXXXXbRXXXXXXXXXXXX-49890947.jpg\",\"http://img01.taobaocdn.com/bao/uploaded/i1/49890947/TB2a2dIapXXXXbKXXXXXXXXXXXX-49890947.jpg\",\"http://img03.taobaocdn.com/bao/uploaded/i3/49890947/TB2sRRLapXXXXaNXXXXXXXXXXXX-49890947.jpg\"],pic: \"http://img04.taobaocdn.com/bao/uploaded/i4/49890947/TB25KBEapXXXXawXpXXXXXXXXXX-49890947.jpg\"},seller:{id:205832587,mode: 0,shopAge:1,status:0}, shop:{\";<div class=\"tb-property tb-property-x\"><div class=\"tb-wrap\"><div id=\"J_Title\"class=\"tb-title\"shortcut-key=\"shortcut-label=\"查看宝贝标题\"shortcut-effect=\"focus\"><h3 class=\"tb-main-title\" data-title=\"男式皮衣皮夹克男士皮衣羊毛呢子外套牛皮皮袖拼接夹克棒球衣服\">男式皮衣皮夹克男士皮衣羊毛呢子外套牛皮皮袖拼接夹克棒球衣</h3><div id=\"J_TEditItem\" class=\"tb-editor-menu\"></div></div><ul class=\"tb-meta\">";
		
		String rex = "^.*auctionImages:\\[(.*)\\],\\s*pic:(.*)\\},\\s*seller.*<div id=\"J_Title\".*data-title=(.*)</h3>*?.*$";
		
		Pattern p = Pattern.compile(rex);
        Matcher m = p.matcher(html1);
//        System.out.println(m.find());
        while (m.find()) {
			System.out.println(m.group(3));
		}
		return null;
	}
	
	public static void main(String[] args) {
		TbHtmlHandle tbHtmlHandle = new TbHtmlHandle();
		tbHtmlHandle.analyze("");
	}
}
