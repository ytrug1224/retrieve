package com.searchengin.util;

import java.net.URL;

import org.junit.Test;

public class TestHtmlUtils {
	
	@Test
	public void test1(){
//		String addressUrl = "http://news.sohu.com/20131025/n388953617.shtml";
		String addressUrl = null;
		String encoding = "utf-8";
		String result = HtmlUtils.getHtmlContent(addressUrl, encoding);
		System.out.println(result);
	}
	
	@Test
	public void test2() throws Exception{
		String addressUrl = "http://sourceforge.net/projects/htmlparser/files/Integration-Builds/2.0-20060923/";
		URL url = new URL(addressUrl);
		String result = HtmlUtils.getCode(url);
		System.out.println(result);
	}
	
	@Test
	public void test3(){
//		String addressUrl = "http://news.sohu.com/20131025/n388953617.shtml";
		String addressUrl = "F:/run/heritrix/jobs/output/mirror/news.sohu.com/20060802/n244587376.shtml";
		String result = HtmlUtils.getHtmlContentUseParser(addressUrl, "gb2312");
		System.out.println(result);
	}
}
