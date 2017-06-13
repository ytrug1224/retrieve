package com.searchengin.test;

import com.searchengin.retrieve.spi.SolrService;

import junit.framework.TestCase;

public class TestClassName extends TestCase{

	public void test1(){
		String className = SolrService.class.getName();
		System.out.println(className);
	}
}
