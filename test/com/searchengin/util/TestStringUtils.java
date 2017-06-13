package com.searchengin.util;

import java.util.List;

import org.junit.Test;

import com.searchengin.config.ConstantParams;

public class TestStringUtils {

	@Test
	public void test1(){
		//<h1 itemprop="headline">ϰ��ƽ�������˹�ͬ����ʶ���ܱ߹����������</h1>
		//<div class="time" itemprop="datePublished" content="2013-10-25T22:29:47+08:00">2013��10��25��22:29</div>
//		String regexString = "<h1 itemprop=\"headline\">(.*)</h1>";
		String regexString = "<div class=\"time\" itemprop=\"datePublished\" content=\"2013-10-25T22:29:47+08:00\">(.*)</div>";
		String addressUrl = "http://news.sohu.com/20131025/n388953617.shtml";
		String sourceString = HtmlUtils.getHtmlContent(addressUrl);
		String result = StringUtils.getContentUseRegex(regexString, sourceString);
		System.out.println(result);
	}
	
	@Test
	public void test2(){
		String regexString = "<div class=\"time\" itemprop=\"datePublished\" content=\"2013-10-25T22:29:47 08:00\">(.*)</div>";
		String sourceString = "<div class=\"time\" itemprop=\"datePublished\" content=\"2013-10-25T22:29:47 08:00\">2013��10��25��22:29</div>";
		String result = StringUtils.getContentUseRegex(regexString, sourceString);
		System.out.println(result);
	}
	
	@Test
	public void test3(){
		String inputPath = "F:/run/20131022";
		StringUtils su = new StringUtils(inputPath);
		List<String> result = su.allPathResult;
		System.out.println(result.size());
	}
	
	@Test
	public void test4(){
		String inputPath = "F:/run/20131022/n388620718.shtml";
		String content = StringUtils.getContent(inputPath);
		System.out.println(content);
	}
	
	@Test
	public void test5(){
		String str = "aaaaaaaaaaaaa���addddddddddd";
		String outputPath = "F:/run/parser/one.txt";
		boolean b = StringUtils.string2File(str, outputPath);
		System.out.println("b:"+b);
	}
	
	@Test
	public void test6(){
//		String inputPath = "F:/run/20131022/n388620718.shtml";
		String inputPath = "F:\\run\\20131022\\n388620718.shtml";
		String result = StringUtils.getFileNameFromPath(inputPath);
		System.out.println(result);
	}
	
	/**
	 * ����������ʽ����ȡ����ƥ��Ķ������
	 */
	@Test
	public void test7(){
		String sourceString = "�Ÿ���/nr ���/v �¼���/ns ��/b ����/n ��־��/nr ";
		String regexString = "[\u4e00-\u9fa5a-zA-Z0-9]*/n(.?) ";
		String splitMark = "";
		String result = StringUtils.getContentUseRegex(regexString, sourceString, splitMark);
		System.out.println(result);
	}
	
	@Test
	public void test8(){
		String fileName = "search.properties";
		String params = "user";
		String result = StringUtils.getConfigParam(params,"test", fileName);
		System.out.println(result);
		
		String url = StringUtils.getConfigParam(ConstantParams.SOLR_URL, "", ConstantParams.SEARCH_CONFIG);
		System.out.println("url:"+url);
	}
	
}
