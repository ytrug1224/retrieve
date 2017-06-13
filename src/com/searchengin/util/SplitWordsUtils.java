package com.searchengin.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import com.searchengin.config.ConstantParams;

public class SplitWordsUtils {

	public static String ikSplit(String str){
		return ikSplit(str,ConstantParams.BLANK);
	}
	public static String ikSplit(String str,String mark){
		String result = "";
		if(StringUtils.isEmpty(str)){
			return result;
		}
		try {
			byte[] bt = str.getBytes();
			InputStream ip = new ByteArrayInputStream(bt);
			Reader read = new InputStreamReader(ip);
			IKSegmenter iks = new IKSegmenter(read,true);
			Lexeme t;
			while((t=iks.next()) != null){
				result += t.getLexemeText()+mark;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 
	 * @param str
	 * @param mark
	 * @param b ��b=true�����ִܷʣ�b=false��ϸ���ȷִ�
	 * @return
	 */
	public static String ikSplit(String str,String mark,boolean b){
		String result = "";
		if(StringUtils.isEmpty(str)){
			return result;
		}
		try {
			byte[] bt = str.getBytes();
			InputStream ip = new ByteArrayInputStream(bt);
			Reader read = new InputStreamReader(ip);
			IKSegmenter iks = new IKSegmenter(read,b);
			Lexeme t;
			while((t=iks.next()) != null){
				result += t.getLexemeText()+mark;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String ikSplit(String str,boolean b){
		return ikSplit(str,ConstantParams.BLANK,b);
	}
}
