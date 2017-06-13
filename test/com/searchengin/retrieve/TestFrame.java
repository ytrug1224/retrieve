package com.searchengin.retrieve;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.FacetField.Count;

import junit.framework.TestCase;

import com.searchengin.retrieve.api.FullTextIndexParams;
import com.searchengin.retrieve.api.FullTextResult;
import com.searchengin.retrieve.api.FullTextSearchParams;
import com.searchengin.retrieve.api.ServerFactory;
import com.searchengin.retrieve.spi.SolrResult;
import com.searchengin.retrieve.spi.SolrService;

public class TestFrame extends TestCase{
	
	SolrService solrService = null;
	
	public void beginService(){
		Map<String,String> params = new HashMap<String,String>();
		params.put("type", "solr");
		params.put("serverName", "test");
		params.put("url", "http://localhost:8080/myfullretrieve");
		ServerFactory serverFactory = new ServerFactory();
		solrService = (SolrService)serverFactory.beginService(params);
		solrService.setServerName("test");
	}

	public void test1(){
		beginService();
		FullTextIndexParams indexParams = new FullTextIndexParams();
		List<Map<String,Object>> indexData = new ArrayList<Map<String,Object>>();
		Map<String,Object> map1 = new HashMap<String,Object>();
		Map<String,Object> map2 = new HashMap<String,Object>();
		map1.put("id", 1);
		map1.put("name", "北风网");
		map1.put("testik", "广州的天气依然很闷热。");
		
		map2.put("id", 2);
		map2.put("name", "百度");
		map2.put("testik", "北京应该很冷了。天气还是不错的。");
		indexData.add(map1);
		indexData.add(map2);
		indexParams.setIndexData(indexData);
		this.solrService.doIndex(indexParams);
	}
	
	public void test2(){
		beginService();
		FullTextResult result = new SolrResult();
		FullTextSearchParams fullTextSearchParams = new FullTextSearchParams();
		String queryWord = "北风网";
		//指定搜索域，并且指定了关系
		/*List<Map<String,String>> assignFields = new ArrayList<Map<String,String>>();
		Map<String,String> map1 = new HashMap<String,String>();
		map1.put("name", "OR");
		map1.put("testik", "OR");
		assignFields.add(map1);
		fullTextSearchParams.setAssignFields(assignFields);
		*/
		
		//指定搜索域，并且默认为OR的关系
		List<String> assignmentFields = new ArrayList<String>();
		assignmentFields.add("name");
		assignmentFields.add("content");
		fullTextSearchParams.setAssignmentFields(assignmentFields);
		
		
		fullTextSearchParams.setQueryWord(queryWord);
		
		//设置显示域
		String[] viewFields = {"id","name","testik"};
		fullTextSearchParams.setViewFields(viewFields);
		
		//高亮
//		fullTextSearchParams.setIsHighlight(false);
		String[] highlightFields = {"name","testik"};
		fullTextSearchParams.setHighlightFields(highlightFields);
		fullTextSearchParams.setPreHighlight("<em>");
		fullTextSearchParams.setPostHighlight("</em>");
		fullTextSearchParams.setViewNums(200);
		
		//排序
		Map<String,Boolean> sortField = new HashMap<String,Boolean>();
		sortField.put("id", true);
		fullTextSearchParams.setSortField(sortField);
		
		//过滤域
		Map<String,String> filterField = new HashMap<String,String>();
		filterField.put("testik", "北京");
		filterField = null;//不过滤
		fullTextSearchParams.setFilterField(filterField);
		
		//分页
		//开始行
		fullTextSearchParams.setStartNums(0);
		//一页显示多少行
		fullTextSearchParams.setPageCount(2);
		
		//facet
		fullTextSearchParams.setIsFacet(true);
		String[] facetFields = {"name"};
		fullTextSearchParams.setFacetFields(facetFields);
		
		result = this.solrService.doQuery(fullTextSearchParams);
		List list = result.getResultList();
		long numFound = result.getNumFound();
		System.out.println("total hits:"+numFound);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		List<FacetField> listField = result.getFacetList();
		 for(FacetField facetField : listField){
			 System.out.println(facetField.getName());
			 List<Count> counts = facetField.getValues();
			 for(Count c : counts){
				 System.out.println(c.getName()+":"+c.getCount());
			 }
		 }
	}
}
