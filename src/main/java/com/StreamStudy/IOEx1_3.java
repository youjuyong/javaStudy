package com.StreamStudy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IOEx1_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	/*	// read() 나 write()이 IOException을 발생 시킬수 있기 때문에 try-catch문으로 감싸주었다.
		avaliable()은 블락킹(blocking) 없이 읽어올수 있는 바이트의 수를 반환한다.
		아마도 예상과 다른 결과가 나왔을 텐데 그이유는 마지막에 읽은 배열의 9번째와 10번요소 값인 9과 9만 출력해야하는데 temp
		에 남아있던 6,7까지 출력했기 때문이다.
		보다 나은 성능을 위해서는 temp에 담긴 내용을 지우고 쓰는 것이 아니라 그냥 기존의 내용 위에 덮어 쓴다. 그래서 temp의
		내용은 '[4,5,6,7]' 이었는데 8과 9를 읽고 난후에 '[8,9,6,7]'이 된다.
		원하는 결과를 얻디 위해서는 아래와같이 읽어온 만큼(len)만 출력하낟.

		while(input.avaliable() > 0) {
			int len = input.read(temp);
			output.write(temp, 0, len);
		}
		
		※블락킹이란 데이터를 읽어 올 때 데이터를 기다리기 위해 멈춰 있는 것을 뜻한다. 예를 들어 사용자가 데이터를 입력하기 전까지 기다
		리고 있을때 블락킹 상태에 있다고 한다.
	*/		
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		byte[] temp = new byte[4]; // 이전 예제와 배열의 크기가 다르다.
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		System.out.println("Input Source :" + Arrays.toString(inSrc));
		
		try {
			while(input.available() > 0) {
				input.read(temp);
				output.write(temp);
				System.out.println("temp :" + Arrays.toString(temp));
				outSrc = output.toByteArray();
				printArrays(temp, outSrc);
			}
		}catch(IOException e) {
			
		}
	}
	
	static void printArrays(byte[] temp, byte[] outSrc) {
		System.out.println("temp          :" + Arrays.toString(temp));
		System.out.println("Output Source :" + Arrays.toString(outSrc));
	}
}
