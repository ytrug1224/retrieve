package com.searchengin.solr;

import org.junit.Test;

public class TestSolrDemo {

	/**
	 * solr������
	 */
	@Test
	public void test1(){
		SolrDemo.solrIndex();
	}
	/**
	 * solr������
	 */
	@Test
	public void test2(){
		SolrDemo.solrSearcher();
	}
	/**
	 * solrɾ������
	 */
	@Test
	public void test3(){
		SolrDemo.solrDelIndex();
	}
}
