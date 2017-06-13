package com.searchengin.solr;

import org.junit.Test;

public class TestSolrDemo {

	/**
	 * solr的索引
	 */
	@Test
	public void test1(){
		SolrDemo.solrIndex();
	}
	/**
	 * solr的搜索
	 */
	@Test
	public void test2(){
		SolrDemo.solrSearcher();
	}
	/**
	 * solr删除索引
	 */
	@Test
	public void test3(){
		SolrDemo.solrDelIndex();
	}
}
