package com.searchengin.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.searchengin.config.ConstantParams;

public class TestExtractUtils {

	/**
	 * ������ʽƥ�������ַ������ģ�Ӣ�ģ����֣�
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
	 * ���ı��ж�ȡ���򣬲�����List��
	 */
	@Test
	public void test2(){
		String inputPath = "D:/result/��һ���� ������Դ/�ڰ˽� ���ķִʣ��ģ�/�ĵ�/rules.txt";
		List<String> result = ExtractUtils.getRules(inputPath);
		for(String s : result){
			System.out.println("s:"+s);
		}
	}
	
	/**
	 * ��ȡ�����ļ��ĺ�ѡ��
	 */
	@Test
	public void test3(){
		String rulesPath = "D:/result/��һ���� ������Դ/�ھŽ� ���ķִʣ��壩/�ĵ�/rules.txt";
		String sourcePath = "D:/result/��һ���� ������Դ/�ھŽ� ���ķִʣ��壩/�ĵ�/ictclassplit/n388620854.txt";
		String outputPath = "D:/result/��һ���� ������Դ/�ھŽ� ���ķִʣ��壩/�ĵ�/singlewordsset.txt";
		ExtractUtils.singleTextWordsSet(rulesPath, sourcePath, outputPath);
	}
	/**
	 * ��ȡ�ļ��еĺ�ѡ��
	 */
	@Test
	public void test4(){
		String rulesPath = "D:/result/��һ���� ������Դ/�ھŽ� ���ķִʣ��壩/�ĵ�/rules.txt";
		String sourcePath = "D:/result/��һ���� ������Դ/�ھŽ� ���ķִʣ��壩/�ĵ�/ictclassplit";
		String outputPath = "D:/result/��һ���� ������Դ/�ھŽ� ���ķִʣ��壩/�ĵ�/wordsset";
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
	 * �����ļ���������ʣ����Ӷ��ʣ��������... ...��
	 */
	@Test
	public void test5(){
		String inputPath = "D:/result/��һ���� ������Դ/�ھŽ� ���ķִʣ��壩/�ĵ�/wordsset/n388620854.txt";
		String outputPath = "D:/result/��һ���� ������Դ/�ھŽ� ���ķִʣ��壩/�ĵ�/filterwords.txt";
		ExtractUtils.filterWords(inputPath, outputPath);
	}
	
	/**
	 * �ļ����е������ļ�����������ʣ����Ӷ��ʣ��������... ...��
	 */
	@Test
	public void test6(){
		String inputPath = "D:/result/��һ���� ������Դ/��ʮ�� ���ķִʣ�����/�ĵ�/wordsset";
		String outputPath = "D:/result/��һ���� ������Դ/��ʮ�� ���ķִʣ�����/�ĵ�/filterwords";
		StringUtils su = new StringUtils(inputPath);
		List<String> filesName = su.allPathResult;
		for(String fileName : filesName){
			String f = StringUtils.getFileNameFromPath(fileName);
			ExtractUtils.filterWords(fileName, outputPath+"/"+f+".txt");
		}
	}
	
	/**
	 * ȥ�������ļ��У���ѡ�ʵ��ظ�
	 */
	@Test
	public void test7(){
		String inputPath = "D:/result/��һ���� ������Դ/��ʮ�� ���ķִʣ�����/�ĵ�/filterwords/n388620718.txt";
		String outputPath = "D:/result/��һ���� ������Դ/��ʮ�� ���ķִʣ�����/�ĵ�/singletest/delrep.txt";
		ExtractUtils.delRepWords(inputPath, outputPath);
	}
	
	/**
	 * ȥ���ļ����������ļ�����ѡ�ʵ��ظ�
	 */
	@Test
	public void test8(){
		String inputPath = "D:/result/��һ���� ������Դ/��ʮ�� ���ķִʣ�����/�ĵ�/filterwords";
		String outputPath = "D:/result/��һ���� ������Դ/��ʮ�� ���ķִʣ�����/�ĵ�/delrepwords";
		StringUtils su = new StringUtils(inputPath);
		List<String> filesName = su.allPathResult;
		for(String fileName : filesName){
			String f = StringUtils.getFileNameFromPath(fileName);
			ExtractUtils.delRepWords(fileName, outputPath+"/"+f+".txt");
		}
	}
	
	@Test
	public void test9(){
		String s = "������/ns �׶�/n ���/ns ";
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
	 * �����ļ��������Թ��˲���
	 */
	@Test
	public void test11(){
		String inputPath = "D:/result/��һ���� ������Դ/��11�� ���ķִʣ��ߣ�/�ĵ�/delrepwords/n388620718.txt";
		String sourcePath = "D:/result/��һ���� ������Դ/��11�� ���ķִʣ��ߣ�/�ĵ�/ictclassplit/n388620718.txt";
		String outputPath = "D:/result/��һ���� ������Դ/��11�� ���ķִʣ��ߣ�/�ĵ�/singletest/integration.txt";
		ExtractUtils.filterInteWords(inputPath, sourcePath, outputPath);
	}
	
	/**
	 * �ļ����������ļ��������Թ��˲���
	 */
	@Test
	public void test12(){
		String inputPath = "D:/result/��һ���� ������Դ/��11�� ���ķִʣ��ߣ�/�ĵ�/delrepwords";
		String sourcePath = "D:/result/��һ���� ������Դ/��11�� ���ķִʣ��ߣ�/�ĵ�/ictclassplit";
		String outputPath = "D:/result/��һ���� ������Դ/��11�� ���ķִʣ��ߣ�/�ĵ�/integration";
		StringUtils su = new StringUtils(inputPath);
		List<String> filesName = su.allPathResult;
		for(String fileName : filesName){
			String f = StringUtils.getFileNameFromPath(fileName);
			ExtractUtils.filterInteWords(fileName,sourcePath+"/"+f+".txt", outputPath+"/"+f+".txt");
		}
	}
	
	/**
	 * �����ļ��Ĵ�Ƶͳ��
	 */
	@Test
	public void test13(){
		String inputPath = "D:/result/��һ���� ������Դ/��12�� ���ķִʣ��ˣ�/�ĵ�/filterwords/n388620718.txt";
		String outputPath = "D:/result/��һ���� ������Դ/��12�� ���ķִʣ��ˣ�/�ĵ�/singletest/statistics.txt";
		ExtractUtils.getNumFromFile(inputPath, outputPath);
	}
	
	/**
	 * �ļ����������ļ��Ĵ�Ƶͳ��
	 */
	@Test
	public void test14(){
		String inputPath = "D:/result/��һ���� ������Դ/��12�� ���ķִʣ��ˣ�/�ĵ�/filterwords";
		String outputPath = "D:/result/��һ���� ������Դ/��12�� ���ķִʣ��ˣ�/�ĵ�/statistics";
		StringUtils su = new StringUtils(inputPath);
		List<String> filesName = su.allPathResult;
		for(String fileName : filesName){
			String f = StringUtils.getFileNameFromPath(fileName);
			ExtractUtils.getNumFromFile(fileName,outputPath+"/"+f+".txt");
		}
	}
	
	/**
	 * �����ļ��Ĵ�Ƶ����
	 */
	@Test
	public void test15(){
		String inputPath = "D:/result/��һ���� ������Դ/��12�� ���ķִʣ��ˣ�/�ĵ�/statistics/n388620718.txt";
		String outputPath = "D:/result/��һ���� ������Դ/��12�� ���ķִʣ��ˣ�/�ĵ�/singletest/sort.txt";
		ExtractUtils.getSortResultForStatistics(inputPath, outputPath);
	}
	
}
