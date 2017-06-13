package com.searchengin.util;

import java.util.List;

import org.junit.Test;

public class TestIctclasUtils {

	/**
	 * ictclas分词
	 */
	@Test
	public void test1(){
		String str = "随后 温 总理 就 离开 了 舟曲县城 ， 预计 温 总理 今天 下午 就 回到 北京";
		String result = IctclasUtils.ictclasSplit(str);
		System.out.println(result);
				
	}
	/**
	 * 对文件夹中每一篇文章进行分词，并且同名保存到另一个文件夹中
	 */
	@Test
	public void test2(){
		String inputPath = "D:/result/第一部分 数据来源/第八讲 中文分词（四）/文档/parser";
		String outputPath = "D:/result/第一部分 数据来源/第八讲 中文分词（四）/文档/ictclassplit";
		StringUtils su = new StringUtils(inputPath);
		List<String> pathList = su.allPathResult;
		for(String path : pathList){
			System.out.println(path);
			String content = StringUtils.getContent(path);
			String result = IctclasUtils.ictclasSplit(content);
			String fileName = StringUtils.getFileNameFromPath(path);
			StringUtils.string2File(result, outputPath+"/"+fileName+".txt");
		}
		
	}
	
	
}
