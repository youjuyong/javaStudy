package com.StreamStudy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IOEx1_4 {

	public static void main(String[] args) {
		
		// 이전 예제의 문제점을 수정 한것으로 temp에 저장된 모든 내용을 출력하는 대신 값을 읽어온 만큼만 출려하도록
		//변경 하였다.
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		byte[] temp = new byte[4];
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		try {
			while(input.available() > 0) {
				int len = input.read(temp); // 읽어온 데이터 수 반환
				output.write(temp,0,len);
			}
		}catch( IOException e) {
			
		}
		
		outSrc = output.toByteArray();
		System.out.println("input source : "  + Arrays.toString(inSrc));
		System.out.println("output source : "  + Arrays.toString(outSrc));
		System.out.println("temp source : "  + Arrays.toString(temp));
	}
}
