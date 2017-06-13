package com.searchengin.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.searchengin.config.ConstantParams;

public class TestSimilaryUtils {

	/**
	 * 测试最小编辑距离
	 */
	@Test
	public void test1(){
		String target = "abd";
		String source = "abc";
		int result = SimilaryUtils.med(target, source);
		System.out.println(result);
	}
	/**
	 * 单个文件分词
	 */
	@Test
	public void test2(){
		String inputPath = "D:/result/第一部分 数据来源/第14讲 网页去重（二）/文档/parser/n388620718.txt";
		String outputPath = "D:/result/第一部分 数据来源/第14讲 网页去重（二）/文档/singletest/splitwords.txt";
		SimilaryUtils.splitWords(inputPath, outputPath);
	}
	/**
	 * 文件夹中所有文件分词
	 */
	@Test
	public void test3(){
		String inputPath = "D:/result/第一部分 数据来源/第14讲 网页去重（二）/文档/parser";
		String outputPath = "D:/result/第一部分 数据来源/第14讲 网页去重（二）/文档/similary/splitwords";
		StringUtils su = new StringUtils(inputPath);
		List<String> filesName = su.allPathResult;
		for(String fileName : filesName){
			String f = StringUtils.getFileNameFromPath(fileName);
			SimilaryUtils.splitWords(fileName,outputPath+"/"+f+".txt");
		}
	}
	
	@Test
	public void test4(){
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("a");
		list.add("1");
		System.out.println(list.size());
	}
	
	/**
	 * 得到某一个词，在某一文章中出现的次数
	 */
	@Test
	public void test5(){
		String inputPath = "D:/result/第一部分 数据来源/第14讲 网页去重（二）/文档/similary/splitwords/n388620718.txt";
		String word = "俄罗斯";
		List<String> list = SimilaryUtils.getAllWords(inputPath);
		Double result = SimilaryUtils.getWordNum(word, list);
		System.out.println(result);
	}
	
	/**
	 * 单个文件TF
	 */
	@Test
	public void test6(){
		String inputPath = "D:/result/第一部分 数据来源/第14讲 网页去重（二）/文档/similary/splitwords/n388620718.txt";
		String outputPath = "D:/result/第一部分 数据来源/第14讲 网页去重（二）/文档/singletest/wordsTf.txt";
		SimilaryUtils.getTF(inputPath, outputPath);
	}
	
	/**
	 * 文件夹中所有文件的TF
	 */
	@Test
	public void test7(){
		String inputPath = "D:/result/第一部分 数据来源/第14讲 网页去重（二）/文档/similary/splitwords";
		String outputPath = "D:/result/第一部分 数据来源/第14讲 网页去重（二）/文档/similary/TF";
		StringUtils su = new StringUtils(inputPath);
		List<String> filesName = su.allPathResult;
		for(String fileName : filesName){
			String f = StringUtils.getFileNameFromPath(fileName);
			SimilaryUtils.getTF(fileName, outputPath+"/"+f+".txt");
		}
	}
	
	/**
	 * 去除重复
	 */
	@Test
	public void test8(){
		String inputPath = "D:/result/第一部分 数据来源/第14讲 网页去重（二）/文档/similary/TF";
		String outputPath = "D:/result/第一部分 数据来源/第14讲 网页去重（二）/文档/similary/delRepTF";
		StringUtils su = new StringUtils(inputPath);
		List<String> filesName = su.allPathResult;
		for(String fileName : filesName){
			String f = StringUtils.getFileNameFromPath(fileName);
			ExtractUtils.delRepWords(fileName, outputPath+"/"+f+".txt");
		}
	}
	
	/**
	 * TF排序
	 */
	@Test
	public void test9(){
		String inputPath = "D:/result/第一部分 数据来源/第14讲 网页去重（二）/文档/similary/TF";
		String outputPath = "D:/result/第一部分 数据来源/第14讲 网页去重（二）/文档/similary/sortTF";
		StringUtils su = new StringUtils(inputPath);
		List<String> filesName = su.allPathResult;
		Map<String,Double> map = new HashMap<String,Double>();
		for(String fileName : filesName){
			String f = StringUtils.getFileNameFromPath(fileName);
			map = SimilaryUtils.getMapFromFile(fileName);
			//排序
			map = SortUtils.sortByValue(map);
			
			Set<String> set = map.keySet();
			Iterator<String> iter = set.iterator();
			String result = "";
			while(iter.hasNext()){
				String key = iter.next();
				Double value = map.get(key);
				result += key+ConstantParams.TABLE+value+ConstantParams.CHENG_LINE;
			}
			StringUtils.string2File(result, outputPath+"/"+f+".txt");
		}
	}
	
	/**
	 * 单个文件DF
	 */
	@Test
	public void test10(){
		String inputPath = "D:/result/第一部分 数据来源/第15讲 网页去重（三）/文档/similary/sortTF/n388620718.txt";
		String outputPath = "D:/result/第一部分 数据来源/第15讲 网页去重（三）/文档/singletest/wordsDF.txt";
		String inputPathAll = "D:/result/第一部分 数据来源/第15讲 网页去重（三）/文档/similary/sortTF";
		SimilaryUtils.getDf(inputPath, inputPathAll, outputPath);
	}
	
	/**
	 * 文件夹中所有文件的DF
	 */
	@Test
	public void test11(){
		String inputPathAll = "D:/result/第一部分 数据来源/第15讲 网页去重（三）/文档/similary/sortTF";
		String outputPath = "D:/result/第一部分 数据来源/第15讲 网页去重（三）/文档/similary/DF";
		StringUtils su = new StringUtils(inputPathAll);
		List<String> filesName = su.allPathResult;
		long start = System.currentTimeMillis();
		for(String fileName : filesName){
			String f = StringUtils.getFileNameFromPath(fileName);
			SimilaryUtils.getDf(fileName,inputPathAll, outputPath+"/"+f+".txt");
		}
		long end = System.currentTimeMillis();
		System.out.println("spent on "+(end-start)+" ms");
	}
	
	/**
	 * 单个文件TFIDF
	 */
	@Test
	public void test12(){
		String inputPath = "D:/result/第一部分 数据来源/第16讲 网页去重（四）/文档/similary/DF/n388620854.txt";
		String outputPath = "D:/result/第一部分 数据来源/第16讲 网页去重（四）/文档/singletest/wordsTFIDF1.txt";
		String inputPathAll = "D:/result/第一部分 数据来源/第16讲 网页去重（四）/文档/similary/sortTF";
		SimilaryUtils.getTfIdf(inputPath, inputPathAll, outputPath);
	}
	
	/**
	 * TFIDF排序
	 */
	@Test
	public void test13(){
		String inputPath = "D:/result/第一部分 数据来源/第16讲 网页去重（四）/文档/singletest/wordsTFIDF1.txt";
		String outputPath = "D:/result/第一部分 数据来源/第16讲 网页去重（四）/文档/singletest/wordsTFIDFSort1.txt";
		Map<String,Double> map = new HashMap<String,Double>();
		int[] flag = {0,3};
			map = SimilaryUtils.getMapFromFile(inputPath,flag);
			//排序
			map = SortUtils.sortByValue(map);
			
			Set<String> set = map.keySet();
			Iterator<String> iter = set.iterator();
			String result = "";
			while(iter.hasNext()){
				String key = iter.next();
				Double value = map.get(key);
				result += key+ConstantParams.TABLE+value+ConstantParams.CHENG_LINE;
			}
			StringUtils.string2File(result, outputPath);
	}
	
	@Test
	public void test14(){
		String inputPath1 = "D:/result/第一部分 数据来源/第16讲 网页去重（四）/文档/singletest/wordsTFIDFSort.txt";
		String inputPath2 = "D:/result/第一部分 数据来源/第16讲 网页去重（四）/文档/singletest/wordsTFIDFSort1.txt";
		SimilaryUtils.getSimilarity(inputPath1, inputPath2, "");
	}
	
}
