package com.searchengin.solr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.FacetField.Count;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.RangeFacet;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import com.searchengin.util.DateUtils;

public class SolrDemo {

	public static void solrIndex(){
		try {
			String url = "http://localhost:8080/solr";
			HttpSolrServer server = new HttpSolrServer(url);
			SolrInputDocument doc = new SolrInputDocument();
			doc.addField("id", "1");
			doc.addField("name", "�й�");
			doc.addField("age", 25);
			doc.addField("date", DateUtils.getYear("2000"));
			doc.addField("content", "��������ǰ���������������ȼ� > solrconfig.xml�����õ�qfֵ > schema.xml�ļ������õ�Ĭ��������");
			doc.addField("testik", "�ڳ�������setFields��������ָ����ʾ�򣬲��Ҹ�ָ�����������ȼ� > solrconfing.xml�����õ�flֵ��schema.xml�ļ������õ�Ĭ��������");
			
			
			SolrInputDocument doc1 = new SolrInputDocument();
			doc1.addField("id", "2");
			doc1.addField("name", "�¼���");
			doc1.addField("age", 30);
			doc1.addField("date", DateUtils.getYear("2013"));
			doc1.addField("content", "��������ǰ���������������ȼ� > solrconfig.xml�����õ�qfֵ > schema.xml�ļ������õ�Ĭ��������");
			doc1.addField("testik", "�ڳ������趨�����������ȼ� > schema.xml�ļ������õ�Ĭ��������");
			
			server.add(doc);
			server.add(doc1);
			server.commit();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 1���ڳ������趨�����������ȼ� > schema.xml�ļ������õ�Ĭ��������
	 * 2����������ǰ���������������ȼ� > solrconfig.xml�����õ�qfֵ > schema.xml�ļ������õ�Ĭ��������
	 * 3���ڳ�������setFields��������ָ����ʾ�򣬲��Ҹ�ָ�����������ȼ� > solrconfing.xml�����õ�flֵ
	 */
	public static void solrSearcher(){
		try {
			String url = "http://localhost:8080/solr";
			HttpSolrServer server = new HttpSolrServer(url);
			SolrQuery params = new SolrQuery("testik:����"); 
			
			//Ĭ��������
//			params.setParam("df", "name");
			
			//��ʾ��
			String[] fields = {"id","name","content","testik","age","date"};
			params.setFields(fields);
			
			//����
			params.addHighlightField("testik");
			params.setHighlight(true);
			params.setHighlightSimplePre("<em class=\"highlight\" >");
			params.setHighlightSimplePost("</em>");
			//��ʾ������
			params.setHighlightFragsize(10);
			
			//����
			params.addSort("age", ORDER.desc);
			
			//����
//			String[] fqs = {"name:�й�"};
//			params.addFilterQuery(fqs);
			
			//��ҳ
			params.setStart(0);
			params.setRows(10);
			
			//facet
			String[] ftf = {"name","content"};
			params.addFacetField(ftf);
			
//			params.addNumericRangeFacet("age", 1, 26, 26);
			params.addDateRangeFacet("date", DateUtils.getYear("1999"), DateUtils.getYear("2015"), "+15YEAR");
			
			QueryResponse response = server.query(params);
			
			/* List<FacetField> listField = response.getFacetFields();
			 for(FacetField facetField : listField){
				 System.out.println(facetField.getName());
				 List<Count> counts = facetField.getValues();
				 for(Count c : counts){
					 System.out.println(c.getName()+":"+c.getCount());
				 }
			 }*/
			
			 List<RangeFacet> listFacet = response.getFacetRanges();
			 for(RangeFacet rf : listFacet){
				 List<RangeFacet.Count> listCounts = rf.getCounts();
				 for(RangeFacet.Count count : listCounts){
					 System.out.println("facet:"+count.getValue()+":"+count.getCount());
				 }
			 }
			
			SolrDocumentList list = response.getResults();
			 Map<String,Map<String,List<String>>> map = response.getHighlighting();
			System.out.println("total hits:"+list.getNumFound());
			for(SolrDocument doc : list){
				System.out.println("name:"+doc.getFieldValue("name"));
				System.out.println("hl:"+map.get(doc.getFieldValue("id")).get("testik").get(0));
				System.out.println("content:"+doc.get("content"));
				System.out.println("age:"+doc.getFieldValue("age"));
				System.out.println("testik:"+doc.get("testik"));
				System.out.println("date:"+doc.get("date"));
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void solrDelIndex(){
		try {
			String url = "http://localhost:8080/solr";
			HttpSolrServer server = new HttpSolrServer(url);
//			server.deleteById("1");
			List<String> ids = new ArrayList<String>();
			ids.add("1");
			ids.add("2");
			server.deleteById(ids);
			server.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
