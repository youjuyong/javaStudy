package com.CollectionsStudy;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 긴 문자열 데이터를 원하는 길이로 잘라서 ArrayList에 담은 다음 출력하는 예제 이다.
		// 순히 문자열을 특정 크기로 잘라서 출력할 것이라면 charAt(int i)와 for문을 이용하면
		// 되겠지만 ArrayList에 잘라서 담아 놓음으로써 ArrayList의 기능을 이용해서 다양한 작업을 간단하게
		// 처리할수 있다.
		
		
		final int LIMIT = 10;
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
		int length = source.length();
		
		List<String> list = new ArrayList(length/LIMIT + 10);
		
		for(int i =0; i < length; i+=LIMIT) {
			if(i+LIMIT < length) {
				list.add(source.substring(i,i+LIMIT));
			} else {
				list.add(source.substring(i));
			}
		}
		
		for(String s : list) {
			System.out.println(s);
		}
		
		
		
	}

}
