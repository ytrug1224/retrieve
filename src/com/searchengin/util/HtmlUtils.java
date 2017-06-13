package com.searchengin.util;

import info.monitorenter.cpdetector.io.CodepageDetectorProxy;
import info.monitorenter.cpdetector.io.JChardetFacade;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;

import com.searchengin.config.ConstantParams;

public class HtmlUtils {

	/**
	 * ��ȡ��ҳ����
	 * @param addressUrl ��ҳ��ַ
	 * @param encoding ��ҳ����
	 * @return ��ҳ����
	 */
	public static String getHtmlContent(String addressUrl,String encoding){
		String result = "";
		if(StringUtils.isEmpty(addressUrl)){
			return "";
		}
		try {
			URL url = new URL(addressUrl);
			InputStreamReader isr = new InputStreamReader(url.openStream(),encoding);
			BufferedReader br = new BufferedReader(isr);
			String temp = "";
			while((temp = br.readLine()) != null){
				result += temp+ConstantParams.CHENG_LINE;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * ��ȡ��ҳ���ݣ������Զ���ȡ��ҳ����
	 * @param addressUrl
	 * @return
	 */
	public static String getHtmlContent(String addressUrl){
		String result = "";
		if(StringUtils.isEmpty(addressUrl)){
			return "";
		}
		try {
			URL url = new URL(addressUrl);
			String code = getCode(url);
			if(StringUtils.isEmpty(code)){
				code = "utf-8";
			}
			result = getHtmlContent(addressUrl,code);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * ��ȡ��ҳ����
	 * @param url
	 * @return
	 */
	public static String getCode(URL url){
		String result = "";
		try {
			CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
			detector.add(JChardetFacade.getInstance());
			Charset charset = detector.detectCodepage(url);
			result = charset.name();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * ����վ������html�����ߣ�
	 * @param addressUrl ��ҳ��ַ
	 * @param encoding ����
	 * @return
	 */
	public static String getHtmlContentUseParser(String addressUrl,String encoding){
		String result = "";
		if(StringUtils.isEmpty(addressUrl)){
			return result;
		}
		if(StringUtils.isEmpty(encoding)){
			encoding = "utf-8";
		}
		try {
			Parser parser = new Parser(addressUrl);
			parser.setEncoding(encoding);
			
			NodeFilter nodeFilter = new AndFilter(new TagNameFilter("div"),new HasAttributeFilter("class","time"));
			NodeList nodeList = parser.parse(nodeFilter);
			parser.reset();
			Node node = nodeList.elementAt(0);
			result = node.toPlainTextString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
