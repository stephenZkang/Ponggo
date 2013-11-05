package com.minlength.test;

/**
 * @see
 * 
 * 		字符串消除
 * 		给定一个字符串，仅由a,b,c 3种小写字母组成。当出现连续两个不同的字母时，
 * 		你可以用另外一个字母替换它，
 * 		如 有ab或ba连续出现，你把它们替换为字母c；
 * 		有ac或ca连续出现时，你可以把它们替换为字母b；
 * 		你可以不断反复按照这个规则进行替换，你的目标是使得最终结果所得到的字符串尽可能短，
 * 		求最终结果的最短长度。 
 * 		输入：字符串。长度不超过200，仅由abc三种小写字母组成。
 * 		输出： 按照上述规则不断消除替换，所得到的字符串最短的长度。 
 * 		例如：输入cab，输出2。因为我们可以把它变为bb或者变为cc。
 * 		输入bcab，输出1。尽管我们可以把它变为aab -> ac -> b，
 * 		 也可以把它变为bbb，但因为前者长度更短，所以输出1。
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
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "abc";
		MinLength length = new MinLength();
		System.out.println("最小长度为:" + length.minlength(s));
	}
}
