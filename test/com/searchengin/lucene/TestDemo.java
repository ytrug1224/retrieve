package com.searchengin.lucene;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.searchengin.util.StringUtils;

public class TestDemo {

	/**
	 * 测试lucene索引
	 */
	@Test
	public void test1(){
		String indexPath = "D:/result/第二部分 索引及搜索封装/第19讲 lucene4.6的各种Query/文档/indexpath";
		Demo.indexDemo(indexPath);
	}
	
	/**
	 * 测试lucene搜索
	 */
	@Test
	public void test2(){
		String indexPath = "D:/result/第二部分 索引及搜索封装/第19讲 lucene4.6的各种Query/文档/indexpath";
		Demo.searcherDemo(indexPath);
	}
	/**
	 * 测试lucene txt文件索引
	 */
	@Test
	public void test3(){
		String indexPath = "D:/result/第二部分 索引及搜索封装/第18讲 lucene4.6索引的相关操作/文档/indexpath";
		String txtPath = "D:/result/第二部分 索引及搜索封装/第18讲 lucene4.6索引的相关操作/文档/parser";
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
	 * 测试lucene删除索引
	 */
	@Test
	public void test4(){
		String indexPath = "D:/result/第二部分 索引及搜索封装/第18讲 lucene4.6索引的相关操作/文档/indexpath";
		Demo.deleteIndex(indexPath);//删除全部
	}
	/**
	 * 测试lucene修改索引
	 */
	@Test
	public void test5(){
		String indexPath = "D:/result/第二部分 索引及搜索封装/第18讲 lucene4.6索引的相关操作/文档/indexpath";
		Demo.updateIndex(indexPath);
	}
	
	/**
	 * 测试lucene高亮器
	 */
	@Test
	public void test6(){
		String indexPath = "D:/result/第二部分 索引及搜索封装/第19讲 lucene4.6的各种Query/文档/indexpath";
		Demo.highlightSearcherDemo(indexPath);
	}
	
}
