package com.searchengin.lucene;

import org.junit.Test;

public class TestQueryDemo {

	@Test
	public void test1(){
		QueryDemo.queryIndex();
	}
	
	@Test
	public void test2(){
		QueryDemo.termQueryDemo();
	}
	
	@Test
	public void test3(){
		QueryDemo.booleanQueryDemo();
	}
	
	@Test
	public void test4(){
		QueryDemo.wildcardQueryDemo();
	}
	
	@Test
	public void test5(){
		QueryDemo.phraseQueryDemo();
	}
	
	@Test
	public void test6(){
		QueryDemo.prefixQueryDemo();
	}
	
	@Test
	public void test7(){
		QueryDemo.multiPhraseQueryDemo();
	}
	
	@Test
	public void test8(){
		QueryDemo.fuzzyQueryDemo();
	}
	
	@Test
	public void test9(){
		QueryDemo.regexpQueryDemo();
	}
	
	@Test
	public void test10(){
		QueryDemo.termRangeQueryDemo();
	}
	
	@Test
	public void test11(){
		QueryDemo.numericRangeQueryDemo();
	}
	
	@Test
	public void test12(){
		QueryDemo.constantScoreQueryDemo();
	}
	
	@Test
	public void test13(){
		QueryDemo.disjunctionMaxQueryDemo();
	}
	
	@Test
	public void test14(){
		QueryDemo.matchAllDocsQueryDemo();
	}
	
	@Test
	public void test15(){
		QueryDemo.multiFieldQueryParserDemo();
	}
	
}
