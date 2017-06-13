package com.searchengin.util;

import org.junit.Test;

public class TestSplitWordsUtils {

	@Test
	public void test1(){
		String str = "随后温总理就离开了舟曲县城，预计温总理今天下午就回到北京。以上就是今天上午的最新动态";
		String result = SplitWordsUtils.ikSplit(str);
		System.out.println(result);
	}
	
	@Test
	public void test2(){
		String str = "天安门在北京，明天凌晨北平要下大雪。";
		String result = SplitWordsUtils.ikSplit(str,false);
		System.out.println(result);
	}
}
