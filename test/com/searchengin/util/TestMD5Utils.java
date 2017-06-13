package com.searchengin.util;

import java.math.BigInteger;

import org.junit.Test;

public class TestMD5Utils {

	@Test
	public void test1(){
//		String str = "ÇØ³¯";//29A55E1F5205DEEF3FFE2BEE28CD3A3A
		String str = "ÀúÊ·";//37FBAC1593E7EC056CE7059B67AF81F3
		MD5Utils md5Utils = new MD5Utils();
		String md5 = md5Utils.getMD5ofStr(str);
		System.out.println(md5);
		BigInteger bi1 = new BigInteger(md5, 16);
		BigInteger bi2 = new BigInteger("29A55E1F5205DEEF3FFE2BEE28CD3A3A", 16);
		BigInteger bi = bi1.add(bi2);
		System.out.println("bi:"+bi);
	}
}
