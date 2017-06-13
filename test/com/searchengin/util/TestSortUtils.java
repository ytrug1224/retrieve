package com.searchengin.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TestSortUtils {

	@Test
	public void test1(){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("a", 1);
		map.put("b", 8);
		map.put("c", 2);
		map.put("d", 10);
		map.put("e", 1);
		
		System.out.println("≈≈–Ú«∞£∫");
		Set<String> set = map.keySet();
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()){
			String key = iter.next();
			Integer value = map.get(key);
			System.out.println(key+":"+value);
		}
		
		System.out.println("==============================");
		System.out.println("≈≈–Ú∫Û£∫");
		Map result = SortUtils.sortByValue(map);
		
		System.out.println("====================");
		Set<String> set1 = result.keySet();
		Iterator<String> iter1 = set1.iterator();
		while(iter1.hasNext()){
			String key = iter1.next();
			Integer value = (Integer)result.get(key);
			System.out.println(key+":"+value);
		}
	}
}
