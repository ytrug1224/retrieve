package com.searchengin.util;

import org.junit.Test;

public class TestSplitWordsUtils {

	@Test
	public void test1(){
		String str = "�����������뿪�������سǣ�Ԥ���������������ͻص����������Ͼ��ǽ�����������¶�̬";
		String result = SplitWordsUtils.ikSplit(str);
		System.out.println(result);
	}
	
	@Test
	public void test2(){
		String str = "�찲���ڱ����������賿��ƽҪ�´�ѩ��";
		String result = SplitWordsUtils.ikSplit(str,false);
		System.out.println(result);
	}
}
