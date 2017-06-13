package com.searchengin.util;

import java.util.List;

import org.junit.Test;

public class TestIctclasUtils {

	/**
	 * ictclas�ִ�
	 */
	@Test
	public void test1(){
		String str = "��� �� ���� �� �뿪 �� �����س� �� Ԥ�� �� ���� ���� ���� �� �ص� ����";
		String result = IctclasUtils.ictclasSplit(str);
		System.out.println(result);
				
	}
	/**
	 * ���ļ�����ÿһƪ���½��зִʣ�����ͬ�����浽��һ���ļ�����
	 */
	@Test
	public void test2(){
		String inputPath = "D:/result/��һ���� ������Դ/�ڰ˽� ���ķִʣ��ģ�/�ĵ�/parser";
		String outputPath = "D:/result/��һ���� ������Դ/�ڰ˽� ���ķִʣ��ģ�/�ĵ�/ictclassplit";
		StringUtils su = new StringUtils(inputPath);
		List<String> pathList = su.allPathResult;
		for(String path : pathList){
			System.out.println(path);
			String content = StringUtils.getContent(path);
			String result = IctclasUtils.ictclasSplit(content);
			String fileName = StringUtils.getFileNameFromPath(path);
			StringUtils.string2File(result, outputPath+"/"+fileName+".txt");
		}
		
	}
	
	
}
