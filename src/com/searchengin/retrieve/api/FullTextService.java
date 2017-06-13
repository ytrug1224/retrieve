package com.searchengin.retrieve.api;

public interface FullTextService {

	//��������
	public int beginService(String serverName);
	
	public int beginService(String serverName,String url);
	
	//flag: 0:IndexWriter 1:IndexSearcher
	public int beginService(String serverName,String flag,String indexPath);
	
	public void setServerName(String serverName);
	
	//�رշ���
	public int endService(String serverName);
	
	//����
	public void doIndex(FullTextIndexParams fullTextIndexParams);
	
	//����֮ǰҪ��������
	public void preIndexMethod();
	
	//����֮��Ҫ��������
	public void afterIndexMethod();
	
	//�޸�����
	public void updateIndex(FullTextIndexParams fullTextIndexParams);
	
	//�޸�֮ǰҪ��������
	public void preUpdateIndexMethod();
	
	//�޸�֮��Ҫ��������
	public void afterUpdateIndexMethod();
	
	//ɾ������
	public void deleteIndex(FullTextIndexParams fullTextIndexParams);
	
	//ɾ��֮ǰҪ��������
	public void preDeleteIndexMethod();
	
	//ɾ��֮��Ҫ��������
	public void afterDeleteIndexMethod();
	
	//����
	public FullTextResult doQuery(FullTextSearchParams fullTextSearchParams);
}
