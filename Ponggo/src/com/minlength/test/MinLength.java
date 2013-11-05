package com.minlength.test;

/**
 * @see
 * 
 * 		�ַ�������
 * 		����һ���ַ���������a,b,c 3��Сд��ĸ��ɡ�����������������ͬ����ĸʱ��
 * 		�����������һ����ĸ�滻����
 * 		�� ��ab��ba�������֣���������滻Ϊ��ĸc��
 * 		��ac��ca��������ʱ������԰������滻Ϊ��ĸb��
 * 		����Բ��Ϸ������������������滻�����Ŀ����ʹ�����ս�����õ����ַ��������̣ܶ�
 * 		�����ս������̳��ȡ� 
 * 		���룺�ַ��������Ȳ�����200������abc����Сд��ĸ��ɡ�
 * 		����� �����������򲻶������滻�����õ����ַ�����̵ĳ��ȡ� 
 * 		���磺����cab�����2����Ϊ���ǿ��԰�����Ϊbb���߱�Ϊcc��
 * 		����bcab�����1���������ǿ��԰�����Ϊaab -> ac -> b��
 * 		 Ҳ���԰�����Ϊbbb������Ϊǰ�߳��ȸ��̣��������1��
 * 
 * @author QIAOK
 * @since 2013-11-05
 */
public class MinLength {
	/**
	 * @see
	 * @param s
	 * @return
	 */
	public int firstIndex(String s){
		char[] charArray = s.toCharArray();
		if(charArray.length>0){
			char head = charArray[0];
			for(int i=1;i < s.length();i++){
				if(head != charArray[i]){
					return i-1;
				}
			}
		}
		return -1;
	}
	
	/**
	 * @see
	 * @param s
	 * @return
	 */
	public int secondIndex(String s){
		char[] charArray = s.toCharArray();
		if(charArray.length > 0){
			char head = charArray[0];
			for (int i = 1; i < s.length(); i++) {
				if(head != charArray[i]){
					if(i < s.length() -1){
						return i;
					}else{
						return -1;
					}
				}
			}
		}
		return -1;
	}
	
	/**
	 * @see
	 * @param s
	 * @return
	 */
	public int countSameChar(String s){
		char[] charArray = s.toCharArray();
		int count = 0;
		if(charArray.length > 0){
			char head = charArray[0];
			for (int i = 0; i < charArray.length; i++) {
				if(head != charArray[i]){
					return count;
				}else{
					count++;
				}
			}
		}
		return count;
	}
	
	
	/**
	 * @see
	 * @param s
	 * @return
	 */
	public String replace(String s){
		if("ac".equals(s) || "ca".equals(s)){
			return "b";
		}else if("ab".equals(s) || "ba".equals(s)){
			return "c";
		}else if("bc".equals(s) || "cb".equals(s)){
			return "a";
		}
		return s;
	}
	
	
	/**
	 * @see
	 * @param s
	 * @param flag
	 * @return
	 */
	public String change(String s,int flag){
		int firstPos = 0;
		int secondPos = 0;
		if(flag == 1){
			firstPos = firstIndex(s);
			String newStr = s.substring(0, firstPos) + replace(s.substring(firstPos, firstPos+2)) + s.substring(firstPos+2);
			return newStr;
		}else{
			secondPos = secondIndex(s);
			if(secondPos == -1){
				return s;
			}else{
				String newStr = s.substring(0, secondPos) + replace(s.substring(secondPos, secondPos+2)) + s.substring(secondPos+2);
				return newStr;
			}
		}
	}
	
	/**
	 * @see
	 * @param s
	 * @return
	 */
	public int minlength(String s){
		if(countSameChar(s) == s.length()){
			return s.length();
		}
		
		String ss1 = change(s, 1);
		String ss2 = change(s, 2);
		
		if(countSameChar(ss1) <= countSameChar(ss2)){
			return minlength(ss1);
		}else{
			return minlength(ss2);
		}
	}
	
	/**
	 * ����
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "abc";
		MinLength length = new MinLength();
		System.out.println("��С����Ϊ:" + length.minlength(s));
	}
}
