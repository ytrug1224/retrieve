package com.searchengin.util;

import java.util.Date;

import org.junit.Test;

public class TestDateUtils {

	@Test
	public void test1(){
		Date date = DateUtils.getYear("2013");
		System.out.println(date);
	}
	
	@Test
	public void test2(){
		Date date = DateUtils.getCurrentYMDHMS();
		System.out.println(date);
	}
}
