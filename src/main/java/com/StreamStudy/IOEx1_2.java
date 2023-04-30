package com.StreamStudy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		byte[] temp = new byte[10];
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		input.read(temp,0,temp.length);
		output.write(temp,5,5);
		
		outSrc = output.toByteArray();
		
		System.out.println("Input Source :" + Arrays.toString(inSrc));
		System.out.println("temp :" + Arrays.toString(inSrc));
		System.out.println("Output Source :" + Arrays.toString(outSrc));
		
		/*
		 * 이전 예제와는 달리 byte배열을 사용해서 한번에 배열의 크기만큼 읽고 쓸 수 있다. 바구니를 이용하면 한번에 더많은 양의 데이터를 읽고
		 * 쓸수 있다.
		 */
	}

}
