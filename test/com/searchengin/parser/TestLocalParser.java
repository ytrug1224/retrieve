package com.searchengin.parser;

import org.junit.Test;

import com.searchengin.com.parser.LocalParser;
import com.searchengin.util.StringUtils;

public class TestLocalParser {

	@Test
	public void test1(){
		LocalParser lp = new LocalParser();
		String inputPath = "F:/run/20131022/n388620718.shtml";
		String outputPath = "F:/run/parser/one.txt";
		String content = StringUtils.getContent(inputPath);
		lp.singleParserSohuNews(content,outputPath);
	}
	
	@Test
	public void test2(){
		LocalParser lp = new LocalParser();
		String inputPath = "F:/run/20131022";
		String outputPath = "F:/run/parser";
		lp.parserSohuNews(inputPath, outputPath);
	}
}
