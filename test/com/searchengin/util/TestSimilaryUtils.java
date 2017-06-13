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
	 * ������С�༭����
	 */
	@Test
	public void test1(){
		String target = "abd";
		String source = "abc";
		int result = SimilaryUtils.med(target, source);
		System.out.println(result);
	}
	/**
	 * �����ļ��ִ�
	 */
	@Test
	public void test2(){
		String inputPath = "D:/result/��һ���� ������Դ/��14�� ��ҳȥ�أ�����/�ĵ�/parser/n388620718.txt";
		String outputPath = "D:/result/��һ���� ������Դ/��14�� ��ҳȥ�أ�����/�ĵ�/singletest/splitwords.txt";
		SimilaryUtils.splitWords(inputPath, outputPath);
	}
	/**
	 * �ļ����������ļ��ִ�
	 */
	@Test
	public void test3(){
		String inputPath = "D:/result/��һ���� ������Դ/��14�� ��ҳȥ�أ�����/�ĵ�/parser";
		String outputPath = "D:/result/��һ���� ������Դ/��14�� ��ҳȥ�أ�����/�ĵ�/similary/splitwords";
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
	 * �õ�ĳһ���ʣ���ĳһ�����г��ֵĴ���
	 */
	@Test
	public void test5(){
		String inputPath = "D:/result/��һ���� ������Դ/��14�� ��ҳȥ�أ�����/�ĵ�/similary/splitwords/n388620718.txt";
		String word = "����˹";
		List<String> list = SimilaryUtils.getAllWords(inputPath);
		Double result = SimilaryUtils.getWordNum(word, list);
		System.out.println(result);
	}
	
	/**
	 * �����ļ�TF
	 */
	@Test
	public void test6(){
		String inputPath = "D:/result/��һ���� ������Դ/��14�� ��ҳȥ�أ�����/�ĵ�/similary/splitwords/n388620718.txt";
		String outputPath = "D:/result/��һ���� ������Դ/��14�� ��ҳȥ�أ�����/�ĵ�/singletest/wordsTf.txt";
		SimilaryUtils.getTF(inputPath, outputPath);
	}
	
	/**
	 * �ļ����������ļ���TF
	 */
	@Test
	public void test7(){
		String inputPath = "D:/result/��һ���� ������Դ/��14�� ��ҳȥ�أ�����/�ĵ�/similary/splitwords";
		String outputPath = "D:/result/��һ���� ������Դ/��14�� ��ҳȥ�أ�����/�ĵ�/similary/TF";
		StringUtils su = new StringUtils(inputPath);
		List<String> filesName = su.allPathResult;
		for(String fileName : filesName){
			String f = StringUtils.getFileNameFromPath(fileName);
			SimilaryUtils.getTF(fileName, outputPath+"/"+f+".txt");
		}
	}
	
	/**
	 * ȥ���ظ�
	 */
	@Test
	public void test8(){
		String inputPath = "D:/result/��һ���� ������Դ/��14�� ��ҳȥ�أ�����/�ĵ�/similary/TF";
		String outputPath = "D:/result/��һ���� ������Դ/��14�� ��ҳȥ�أ�����/�ĵ�/similary/delRepTF";
		StringUtils su = new StringUtils(inputPath);
		List<String> filesName = su.allPathResult;
		for(String fileName : filesName){
			String f = StringUtils.getFileNameFromPath(fileName);
			ExtractUtils.delRepWords(fileName, outputPath+"/"+f+".txt");
		}
	}
	
	/**
	 * TF����
	 */
	@Test
	public void test9(){
		String inputPath = "D:/result/��һ���� ������Դ/��14�� ��ҳȥ�أ�����/�ĵ�/similary/TF";
		String outputPath = "D:/result/��һ���� ������Դ/��14�� ��ҳȥ�أ�����/�ĵ�/similary/sortTF";
		StringUtils su = new StringUtils(inputPath);
		List<String> filesName = su.allPathResult;
		Map<String,Double> map = new HashMap<String,Double>();
		for(String fileName : filesName){
			String f = StringUtils.getFileNameFromPath(fileName);
			map = SimilaryUtils.getMapFromFile(fileName);
			//����
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
	 * �����ļ�DF
	 */
	@Test
	public void test10(){
		String inputPath = "D:/result/��һ���� ������Դ/��15�� ��ҳȥ�أ�����/�ĵ�/similary/sortTF/n388620718.txt";
		String outputPath = "D:/result/��һ���� ������Դ/��15�� ��ҳȥ�أ�����/�ĵ�/singletest/wordsDF.txt";
		String inputPathAll = "D:/result/��һ���� ������Դ/��15�� ��ҳȥ�أ�����/�ĵ�/similary/sortTF";
		SimilaryUtils.getDf(inputPath, inputPathAll, outputPath);
	}
	
	/**
	 * �ļ����������ļ���DF
	 */
	@Test
	public void test11(){
		String inputPathAll = "D:/result/��һ���� ������Դ/��15�� ��ҳȥ�أ�����/�ĵ�/similary/sortTF";
		String outputPath = "D:/result/��һ���� ������Դ/��15�� ��ҳȥ�أ�����/�ĵ�/similary/DF";
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
	 * �����ļ�TFIDF
	 */
	@Test
	public void test12(){
		String inputPath = "D:/result/��һ���� ������Դ/��16�� ��ҳȥ�أ��ģ�/�ĵ�/similary/DF/n388620854.txt";
		String outputPath = "D:/result/��һ���� ������Դ/��16�� ��ҳȥ�أ��ģ�/�ĵ�/singletest/wordsTFIDF1.txt";
		String inputPathAll = "D:/result/��һ���� ������Դ/��16�� ��ҳȥ�أ��ģ�/�ĵ�/similary/sortTF";
		SimilaryUtils.getTfIdf(inputPath, inputPathAll, outputPath);
	}
	
	/**
	 * TFIDF����
	 */
	@Test
	public void test13(){
		String inputPath = "D:/result/��һ���� ������Դ/��16�� ��ҳȥ�أ��ģ�/�ĵ�/singletest/wordsTFIDF1.txt";
		String outputPath = "D:/result/��һ���� ������Դ/��16�� ��ҳȥ�أ��ģ�/�ĵ�/singletest/wordsTFIDFSort1.txt";
		Map<String,Double> map = new HashMap<String,Double>();
		int[] flag = {0,3};
			map = SimilaryUtils.getMapFromFile(inputPath,flag);
			//����
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
		String inputPath1 = "D:/result/��һ���� ������Դ/��16�� ��ҳȥ�أ��ģ�/�ĵ�/singletest/wordsTFIDFSort.txt";
		String inputPath2 = "D:/result/��һ���� ������Դ/��16�� ��ҳȥ�أ��ģ�/�ĵ�/singletest/wordsTFIDFSort1.txt";
		SimilaryUtils.getSimilarity(inputPath1, inputPath2, "");
	}
	
}
