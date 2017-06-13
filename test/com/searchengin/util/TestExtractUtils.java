package com.searchengin.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.searchengin.config.ConstantParams;

public class TestExtractUtils {

	/**
	 * 正则表达式匹配所有字符（中文，英文，数字）
	 */
	@Test
	public void test1(){
		String regex = "[\u4e00-\u9fa5a-zA-Z0-9]*";
		String testStr = "aa";
		if(testStr.matches(regex)){
			System.out.println("t");
		}else{
			System.out.println("f");
		}
	}
	
	/**
	 * 从文本中读取规则，并放入List中
	 */
	@Test
	public void test2(){
		String inputPath = "D:/result/第一部分 数据来源/第八讲 中文分词（四）/文档/rules.txt";
		List<String> result = ExtractUtils.getRules(inputPath);
		for(String s : result){
			System.out.println("s:"+s);
		}
	}
	
	/**
	 * 抽取单个文件的候选集
	 */
	@Test
	public void test3(){
		String rulesPath = "D:/result/第一部分 数据来源/第九讲 中文分词（五）/文档/rules.txt";
		String sourcePath = "D:/result/第一部分 数据来源/第九讲 中文分词（五）/文档/ictclassplit/n388620854.txt";
		String outputPath = "D:/result/第一部分 数据来源/第九讲 中文分词（五）/文档/singlewordsset.txt";
		ExtractUtils.singleTextWordsSet(rulesPath, sourcePath, outputPath);
	}
	/**
	 * 抽取文件夹的候选集
	 */
	@Test
	public void test4(){
		String rulesPath = "D:/result/第一部分 数据来源/第九讲 中文分词（五）/文档/rules.txt";
		String sourcePath = "D:/result/第一部分 数据来源/第九讲 中文分词（五）/文档/ictclassplit";
		String outputPath = "D:/result/第一部分 数据来源/第九讲 中文分词（五）/文档/wordsset";
		StringUtils su = new StringUtils(sourcePath);
		List<String> filesName = su.allPathResult;
		int count = 0;
		for(String fileName : filesName){
			long start = System.currentTimeMillis();
//			String sourceString = StringUtils.getContent(fileName);
			String f = StringUtils.getFileNameFromPath(fileName);
			ExtractUtils.singleTextWordsSet(rulesPath, fileName, outputPath+"/"+f+".txt");
			long end = System.currentTimeMillis();
			System.out.println((++count)+" "+(end-start)+" ms:"+fileName);
		}
	}
	
	/**
	 * 单个文件过滤特殊词（单子动词，特殊符号... ...）
	 */
	@Test
	public void test5(){
		String inputPath = "D:/result/第一部分 数据来源/第九讲 中文分词（五）/文档/wordsset/n388620854.txt";
		String outputPath = "D:/result/第一部分 数据来源/第九讲 中文分词（五）/文档/filterwords.txt";
		ExtractUtils.filterWords(inputPath, outputPath);
	}
	
	/**
	 * 文件夹中的所有文件，过滤特殊词（单子动词，特殊符号... ...）
	 */
	@Test
	public void test6(){
		String inputPath = "D:/result/第一部分 数据来源/第十讲 中文分词（六）/文档/wordsset";
		String outputPath = "D:/result/第一部分 数据来源/第十讲 中文分词（六）/文档/filterwords";
		StringUtils su = new StringUtils(inputPath);
		List<String> filesName = su.allPathResult;
		for(String fileName : filesName){
			String f = StringUtils.getFileNameFromPath(fileName);
			ExtractUtils.filterWords(fileName, outputPath+"/"+f+".txt");
		}
	}
	
	/**
	 * 去除单个文件中，候选词的重复
	 */
	@Test
	public void test7(){
		String inputPath = "D:/result/第一部分 数据来源/第十讲 中文分词（六）/文档/filterwords/n388620718.txt";
		String outputPath = "D:/result/第一部分 数据来源/第十讲 中文分词（六）/文档/singletest/delrep.txt";
		ExtractUtils.delRepWords(inputPath, outputPath);
	}
	
	/**
	 * 去除文件夹中所有文件，候选词的重复
	 */
	@Test
	public void test8(){
		String inputPath = "D:/result/第一部分 数据来源/第十讲 中文分词（六）/文档/filterwords";
		String outputPath = "D:/result/第一部分 数据来源/第十讲 中文分词（六）/文档/delrepwords";
		StringUtils su = new StringUtils(inputPath);
		List<String> filesName = su.allPathResult;
		for(String fileName : filesName){
			String f = StringUtils.getFileNameFromPath(fileName);
			ExtractUtils.delRepWords(fileName, outputPath+"/"+f+".txt");
		}
	}
	
	@Test
	public void test9(){
		String s = "卡塔尔/ns 首都/n 多哈/ns ";
		String[] ss = s.split(ConstantParams.SINGLE_BLANK);
		System.out.println(ss.length);
	}
	
	@Test
	public void test10(){
		Set<String> set = new HashSet<String>();
		set.add("aa");
		set.add("aa");
		set.add("ba");
		set.add("aa");
		set.add("aa");
		set.add("aa");
		set.add("aa");
		System.out.println(set.size());
	}
	
	/**
	 * 单个文件的完整性过滤测试
	 */
	@Test
	public void test11(){
		String inputPath = "D:/result/第一部分 数据来源/第11讲 中文分词（七）/文档/delrepwords/n388620718.txt";
		String sourcePath = "D:/result/第一部分 数据来源/第11讲 中文分词（七）/文档/ictclassplit/n388620718.txt";
		String outputPath = "D:/result/第一部分 数据来源/第11讲 中文分词（七）/文档/singletest/integration.txt";
		ExtractUtils.filterInteWords(inputPath, sourcePath, outputPath);
	}
	
	/**
	 * 文件夹中所有文件的完整性过滤测试
	 */
	@Test
	public void test12(){
		String inputPath = "D:/result/第一部分 数据来源/第11讲 中文分词（七）/文档/delrepwords";
		String sourcePath = "D:/result/第一部分 数据来源/第11讲 中文分词（七）/文档/ictclassplit";
		String outputPath = "D:/result/第一部分 数据来源/第11讲 中文分词（七）/文档/integration";
		StringUtils su = new StringUtils(inputPath);
		List<String> filesName = su.allPathResult;
		for(String fileName : filesName){
			String f = StringUtils.getFileNameFromPath(fileName);
			ExtractUtils.filterInteWords(fileName,sourcePath+"/"+f+".txt", outputPath+"/"+f+".txt");
		}
	}
	
	/**
	 * 单个文件的词频统计
	 */
	@Test
	public void test13(){
		String inputPath = "D:/result/第一部分 数据来源/第12讲 中文分词（八）/文档/filterwords/n388620718.txt";
		String outputPath = "D:/result/第一部分 数据来源/第12讲 中文分词（八）/文档/singletest/statistics.txt";
		ExtractUtils.getNumFromFile(inputPath, outputPath);
	}
	
	/**
	 * 文件夹中所有文件的词频统计
	 */
	@Test
	public void test14(){
		String inputPath = "D:/result/第一部分 数据来源/第12讲 中文分词（八）/文档/filterwords";
		String outputPath = "D:/result/第一部分 数据来源/第12讲 中文分词（八）/文档/statistics";
		StringUtils su = new StringUtils(inputPath);
		List<String> filesName = su.allPathResult;
		for(String fileName : filesName){
			String f = StringUtils.getFileNameFromPath(fileName);
			ExtractUtils.getNumFromFile(fileName,outputPath+"/"+f+".txt");
		}
	}
	
	/**
	 * 单个文件的词频排序
	 */
	@Test
	public void test15(){
		String inputPath = "D:/result/第一部分 数据来源/第12讲 中文分词（八）/文档/statistics/n388620718.txt";
		String outputPath = "D:/result/第一部分 数据来源/第12讲 中文分词（八）/文档/singletest/sort.txt";
		ExtractUtils.getSortResultForStatistics(inputPath, outputPath);
	}
	
}
