package com.searchengin.com.parser;

import java.util.List;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;

import com.searchengin.config.ConstantParams;
import com.searchengin.util.StringUtils;

public class LocalParser {

	public void parserSohuNews(String inputPath,String outputPath){
		StringUtils su = new StringUtils(inputPath);
		List<String> allPath = su.allPathResult;
		for(String path : allPath){
			String htmlContent = StringUtils.getContent(path);
			String fileName = StringUtils.getFileNameFromPath(path);
			singleParserSohuNews(htmlContent, outputPath+"/"+fileName+".txt");
		}
	}
	
	public void singleParserSohuNews(String htmlContent,String outputPath){
		try {
			Parser parser = Parser.createParser(htmlContent, "gb2312");
			NodeFilter title_Filter = new AndFilter(new TagNameFilter("h1"),new HasAttributeFilter("itemprop","headline"));
			NodeList title_List = parser.parse(title_Filter);
			Node title_node = title_List.elementAt(0);
			String title = "";
			if(title_node != null){
				title = title_node.toPlainTextString();
			}
			parser.reset();
			NodeFilter date_Filter = new AndFilter(new TagNameFilter("div"),new HasAttributeFilter("class","time"));
			NodeList date_list = parser.parse(date_Filter);
			Node date_node = date_list.elementAt(0);
			String date = "";
			if(date_node != null){
				date = date_node.toPlainTextString();
			}
			parser.reset();
			NodeFilter source_Filter = new AndFilter(new TagNameFilter("span"),new HasAttributeFilter("itemprop","name"));
			NodeList source_list = parser.parse(source_Filter);
			Node source_node = source_list.elementAt(0);
			String source = "";
			if(source_node != null){
				source = source_node.toPlainTextString();
			}
			parser.reset();
			NodeFilter content_Filter = new AndFilter(new TagNameFilter("div"),new HasAttributeFilter("itemprop","articleBody"));
			NodeList content_list = parser.parse(content_Filter);
			Node content_node = content_list.elementAt(0);
			String content = "";
			if(content_node != null){
				content = content_node.toPlainTextString();
			}
			parser.reset();
			String result = title+ConstantParams.CHENG_LINE+date+ConstantParams.CHENG_LINE+source+ConstantParams.CHENG_LINE+content;
			StringUtils.string2File(result, outputPath);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
