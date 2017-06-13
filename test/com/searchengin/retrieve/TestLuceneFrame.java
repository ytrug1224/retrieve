package com.searchengin.retrieve;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.searchengin.retrieve.api.FullTextIndexParams;
import com.searchengin.retrieve.api.FullTextResult;
import com.searchengin.retrieve.api.FullTextSearchParams;
import com.searchengin.retrieve.api.ServerFactory;
import com.searchengin.retrieve.spi.LuceneService;

public class TestLuceneFrame extends TestCase{
	LuceneService luceneService = null;
	
	public void beginService(String flag){
		Map<String,String> params = new HashMap<String,String>();
		params.put("type", "lucene");
		params.put("serverName", "test");
		params.put("flag", flag);
		params.put("className", LuceneService.class.getName());
		params.put("indexPath", "D:/tomcat8/webapps/mysearch/indexPath");
		ServerFactory serverFactory = new ServerFactory();
		luceneService = (LuceneService)serverFactory.beginService(params);
		luceneService.setServerName("test");
	}

	public void test1(){
		//启动服务
		beginService("writer");
		
		FullTextIndexParams fullTextIndexParams = new FullTextIndexParams();
		List<Map<String,Object>> indexData = new ArrayList<Map<String,Object>>();
		Map<String,Object> map1 = new HashMap<String,Object>();
		Map<String,Object> map2 = new HashMap<String,Object>();
		map1.put("id", 1);
		map1.put("name", "北风网");
		map1.put("testik", "广州的天气依然很闷热。");
		
		map2.put("id", 2);
		map2.put("name", "百度");
		map2.put("testik", "北京应该很冷了。天气还是不错的。北风那个吹，雪花那个飘。");
		indexData.add(map1);
		indexData.add(map2);
		fullTextIndexParams.setIndexData(indexData);
		luceneService.doIndex(fullTextIndexParams);
	}
	public void test2(){
		//启动服务
		beginService("search");
		
		FullTextSearchParams fullTextSearchParams = new FullTextSearchParams();
		
		fullTextSearchParams.setQueryWord("pdf");
		
		fullTextSearchParams.setReturnNums(10);
		
		List<String> assignmentFields = new ArrayList<String>();
//		assignmentFields.add("name");
//		assignmentFields.add("testik");
		assignmentFields.add("fdName");
		fullTextSearchParams.setAssignmentFields(assignmentFields);
		
//		String[] viewFields = new String[]{"name","testik"};
		String[] viewFields = new String[]{"docfullid","fdName"};
		fullTextSearchParams.setViewFields(viewFields);
		
		fullTextSearchParams.setViewNums(200);
		
		fullTextSearchParams.setIsHighlight(true);
		
		Map<String,String> filterField = new HashMap<String,String>();
		filterField.put("name", "百度");
//		fullTextSearchParams.setFilterField(filterField);
		
//		Map<String,Float> boost = new HashMap<String,Float>();
//		boost.put("name", 1.0f);
//		boost.put("testik", 9.0f);
//		fullTextSearchParams.setBoost(boost);
		
		FullTextResult result = luceneService.doQuery(fullTextSearchParams);
		System.out.println(result.getNumFound());
		List list = result.getResultList();
		System.out.println("list size:"+list.size());
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	
	}
	
	public void test3(){
		//启动服务
		beginService("writer");
		
		FullTextIndexParams fullTextIndexParams = new FullTextIndexParams();
		fullTextIndexParams.setId("19");
		
		luceneService.deleteIndex(fullTextIndexParams);
	}
}
