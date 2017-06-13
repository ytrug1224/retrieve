package com.searchengin.util;

import ICTCLAS.I3S.AC.ICTCLAS50;

public class IctclasUtils {
	
	/**
	 * ictclas�ִ�
	 * @param str
	 * @return
	 */
	public static String ictclasSplit(String str){
		String result = "";
		try{
			ICTCLAS50 testICTCLAS50 = new ICTCLAS50();
			String argu = ".";
			//��ʼ��
			if (testICTCLAS50.ICTCLAS_Init(argu.getBytes("GB2312")) == false){
				System.out.println("Init Fail!");
				return "";
			}
			//���ô��Ա�ע��(0 ������������ע����1 ������һ����ע����2 ���������ע����3 ����һ����ע��)
			testICTCLAS50.ICTCLAS_SetPOSmap(2);
			//�����û��ʵ�ǰ�ִ�
			byte nativeBytes[] = testICTCLAS50.ICTCLAS_ParagraphProcess(str.getBytes("GB2312"), 0, 1);//�ִʴ���
			result = new String(nativeBytes, 0, nativeBytes.length, "GB2312");

			//�ͷŷִ������Դ
			testICTCLAS50.ICTCLAS_Exit();
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		return result;
	}
}
