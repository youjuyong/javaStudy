package com.StreamStudy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	
		2. 바이트 기반 스트림
		
		2.1 InputStream과 OutPutStream
		
		앞서 얘기한 바와 같이 InputStream과 OutputStream은 모든 바이트 기반의 스트림의 조상이며 다음과 같은 메서드가
		선언되어 있다.
		
		메서드명 (inputStream)								설명
		int avaliable() :			스트림으로부터 읽어 올 수 있는 데이터의 크기를 반환한다.
		
		void close()    :           스트림을 닫음으로써 사용하고 있던 자원을 반환한다.
		
		void mark(int readlimit)  : 현재 위치를 표시해 놓는다. 후에 reset()에 의해서 표시해 놓은 위치로 다시
									돌아갈 수있다. readlimit은 되돌아 갈수 있는 byte의 수이다.
		
		boolean markSupported()   : mark()와 reset()을 지원하는 지를 알려 준다. mark()와 reset() 기능을 지원하는
									것은 선택적이므로 mark()와 reset()을 사용하기 전에 markSupported()를 호출해서
									지원여부를 확인해야한다.
								
		abstract int read()       : 1byte를 읽어온다(0 ~255사이의 값). 더 이상 읽어올 데이터가 없으면 -1을 반환한다.
									abstract 메서드 라서 InputStream의 자손들은 자신의 상황에 알맞게 구현해야한다.
		
		int read(byte[] b)        : 배열 b의 크기만큼 읽어서 배열을 채우고 읽어온 데이터의 수를 반환한다. 반환하는 값은
									항상 배열의 크기보다 작거나 같다.
		
		int read(byte[] b, int off, int len) : 최대 len개의 byte를 읽어서, 배열 b의 지정된 위치(off) 부터 저장한다.
											   실제로 읽어올 수 있는 데이터가 len개 보다 적을 수 있다ㅣ.
								
		void reset()              : 스트림에서의 위치를 마지막으로 mark()이 호출 되었던 위치로 되돌린다.
	
		long skip(long n)         : 스트림에서 주어진 길이(n)만큼을 건너 뛴다.
			
			
		메서드명 (outputSAtream)     						설명 
		void cloas()			   			   : 입력 소스를 닫음으로써 사용하고 있던 자원을 반환한다.
		
		void flush() 			   			   : 스트림의 버퍼에 있는 모든 내용을 출력소스에 쓴다.
		
		abstract void write(int b) 			   : 주어진 값을 출력 소스에 사용한다.
		
		void write(byte[] b)       			   : 주어진 배열 b에 저장된 모든 내용을 출력소스에 쓴다.
		
		void write(byte[] b, int off, int len) : 주어진 배열 b에 저장된 내용 중에서 off번째부터 len개 만큼만을 읽어서
												 출력소스에 쓴다.

		스트림의 종류에 따라서 mark()와 reset()을 사용하여 이미 읽은 데이터를 되돌려서 다시 읽을 수 있다.
		이기능을 지원하는 스트림인지 확인하는 markSupported()를 통해서 알 수 있다.
		flush()는 버퍼가 있는 출력 스트림의 경우에만 의미가 있으며, OutputStream에 정의된 flush()는 아무런 일도 하지않는다.
		
		프로그램이 종료될때 사용하고 닫지 않는 스트림을 JVM이 자동적으로 닫아주기는 하지만 스트림을 사용해서 모든 작업을 마치고 난 후에는
		close()를 호출해서 반드시 닫아 주어야 한다. 그러나 ByteArrayInputStream과 같이 메모리를 사용하는 스트림과
		System.in, System.out 과 같은 표출 입출력 스트림은 닫아 주지 않아도 된다.
		
		2.2 ByteArrayInputStream과 ByteArrayOutputStream
		
		ByteArrayInputStream/ ByteArrayOutputStream은 메모리, 즉 바이트배열에 데이터를 입출력 하는데 사용되는 스트림이다.
		주로 다른 곳에 입출력하기 전에 데이터를 임시로 바이트 배열에 변환등의 작업을 하는데 사용된다. 
	*/
		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outSrc = null;
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		int data = 0;
		
		while ((data = input.read()) != -1) {
			output.write(data);
		}
		
		outSrc = output.toByteArray(); // 스트림의 내용을 Byte 배열로 반환한다.
		
		System.out.println("Input Source : " + Arrays.toString(inSrc));
		System.out.println("Output Source : " + Arrays.toString(outSrc));
		
		/*
		 * 바이트배열은 사용하는 자원이 메모리 밖에 없으므로 가비지 컬렉터에 의해 자동으로 자원을 반환하므로 close()를 이용해서 스트림을 닫지
		 * 않아도 된다. read()와 write(int b)를 사용하기 때문에 한번에 1byte만 읽고 쓰므로 작업효율이 떨어진다.
		 */
		
		
		
		
	}
}
