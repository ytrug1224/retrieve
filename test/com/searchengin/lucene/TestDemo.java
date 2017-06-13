package com.searchengin.lucene;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.searchengin.util.StringUtils;

public class TestDemo {

	/**
	 * ����lucene����
	 */
	@Test
	public void test1(){
		String indexPath = "D:/result/�ڶ����� ������������װ/��19�� lucene4.6�ĸ���Query/�ĵ�/indexpath";
		Demo.indexDemo(indexPath);
	}
	
	/**
	 * ����lucene����
	 */
	@Test
	public void test2(){
		String indexPath = "D:/result/�ڶ����� ������������װ/��19�� lucene4.6�ĸ���Query/�ĵ�/indexpath";
		Demo.searcherDemo(indexPath);
	}
	/**
	 * ����lucene txt�ļ�����
	 */
	@Test
	public void test3(){
		String indexPath = "D:/result/�ڶ����� ������������װ/��18�� lucene4.6��������ز���/�ĵ�/indexpath";
		String txtPath = "D:/result/�ڶ����� ������������װ/��18�� lucene4.6��������ز���/�ĵ�/parser";
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = null;
		StringUtils su = new StringUtils(txtPath);
		List<String> filesName = su.allPathResult;
		int id = 0;
		for(String fileName : filesName){
			map = new HashMap<String,Object>();
			String name = StringUtils.getFileNameFromPath(fileName);
			String content = StringUtils.getContent(fileName);
			map.put("id", ++id+"");
			map.put("name", name);
			map.put("content", content);
			list.add(map);
		}
		Demo.indexDemo(list, indexPath);
	}
	
	/**
	 * ����luceneɾ������
	 */
	@Test
	public void test4(){
		String indexPath = "D:/result/�ڶ����� ������������װ/��18�� lucene4.6��������ز���/�ĵ�/indexpath";
		Demo.deleteIndex(indexPath);//ɾ��ȫ��
	}
	/**
	 * ����lucene�޸�����
	 */
	@Test
	public void test5(){
		String indexPath = "D:/result/�ڶ����� ������������װ/��18�� lucene4.6��������ز���/�ĵ�/indexpath";
		Demo.updateIndex(indexPath);
	}
	
	/**
	 * ����lucene������
	 */
	@Test
	public void test6(){
		String indexPath = "D:/result/�ڶ����� ������������װ/��19�� lucene4.6�ĸ���Query/�ĵ�/indexpath";
		Demo.highlightSearcherDemo(indexPath);
	}
	
}
