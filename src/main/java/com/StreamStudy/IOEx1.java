package com.StreamStudy;

import java.io.BufferedInputStream;

public class IOEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	
		1. 자바에서의 입출력
		1.1 입출력 이란?
			
		I/O란 Input과 Output의 약자로 입력과 출려, 간단히 줄여서 입출력이라고 한다.,args 입출력은 컴퓨터 내부 또는
		외부의 장치와 프로그램 간의 데이터를 주고 받는 것을 말한다.
		예를 들면 키보드로 부터 데이터를 입력 받는 다든가 System.out.print()을 이용해서 화면에 출력한다던가 하는 것이 가장 
		기본적인 입출력의 예이다.
		
		1.2 스트림 (Stream)
		
		자바에서 입출력을 수행하려면, 즉 어느 한쪽에서 다른쪽으로 데이터를 전달혀려면, 두 대상을 연결하고 데이터를 전송할 수있는
		무언가가 필요한데 이것을 스트림(stream) 이라고 정의했다.
		
		"스트림이란 데이터를 운반하는데 사용되는 연결 통로이다."
		
		스트림은 연속 적인 데이터의 흐름을 물에 비유해서 붙여진 이름인데, 여러가지로 유사한 점이 많다.
		물이 한쪽 방향으로만 흐르는 것과 같이 스트림은 단방향통신만 
		
		java 애플리케이션			입력 스트림			  파일(Text.txt)
		int ch = in.read();   <---------- "Hello" Hello
		
		out.write("world");    ---------->
						"dlrow" 출려 스트림
		
		스트림은 먼저 보낸 데이터를 먼저 받게 되어 있으며 중간에 건너뜀 없이 연속적으로 데이터를 주고 받는다.
		큐(Queue)와 같은 FIFO구조로 되어 있다.
		
		1.3 바이트 기반 스트림
		입력 스트림    				출력 스트림					입출력 대상의 종류
		FileInputStream			FileOutPutStream		파일
		ByteArrayInputStream	ByteArrayOutputStream	메모리 (byte 배열)
		AudioInputStrea			AudioOutputStream		오디오 장치
		PipedInputStream        PipedOutputStream 		프로세스 (프로세스 간의 통신)
		
		이와 같이 여러 종류의 스트림이 있으며 , 어떠한 대상에 대해서 작업을 할 것인지 그리고 입력을 할 것인지
		출력을 할 것인지에 따라서 해당 스트림을 선택해서 사용 하면 된다.
		예를 들어 어떤 파일의 내용을 읽고자 하는 경우 FileInputStream을 사용하면 될것이다.
		이들은 모두 InputStream또는 OutputStream의 자손듥이며, 각각 읽고 쓰는데 필요한 추상 메서드를 자신에
		맞게 구현해 놓았다.
		
		InputStream				   				OutputStream
		abstreact int read () 					abstract void write (int b)
		int read(byte[] b)						void write(byte[] b)
		int read(byte[] b,int off, int len)		void write(byte[] b, int off, int len)
		
		read()의 반환 타입이 int인 이유는 read()의 반환값의 범위가 0~255 와 -1이기 때문이다.
		
		위의 표에 나온 메서드의 사용법만 알고 있어도 데이터를 읽고 쓰는 것은 입출력 대상의 종류에 관계없이 아주 간단한 일이 될것이다.
		InputStream의 read()와 OutputStream의 write는 입출력의 대상에 따라 읽고 쓰는 방법이 다를 것이기
		때문에 각 상황에 알맞게 구현하라는 의미에서 추상메서드로 정의 되어있다.
		
		read()와 write(int b)를 제외한 나머지 메서드들은 추상메서드가 아니니까 굳이 추상메서드인 read()와 write(int b)를 구현하지
		않아도 이들을 사용하면 될 것같지만 사실 추상메서드인 read()와 wrtie(int b)를 이용해서 구현한 것들이기 때문에 read()와
		write(int b)를 구현해야한다.
		
		public abstract class InputStream {
				・・・
				// 입력 스트링ㅁ으로 부터 1byte를 읽어서 반환 한다. 읽을 수 없으면 -1을 반환한다.
				abstract int read();
				
				// 입력 스트림으로부터 len개의 byte를 읽어서 byte배열 b의 off 위치부터 저장한다.
				int read(byte[] b, int off, int len) {
					・・・
					for(int i = off; i < off + len; i++) {
						// read()를 호출해서 데이터를 읽어서 배열을 채운다.
						b[i] = (byte) read();
					}
				}
				・・・
				// 입력스트림으로부터 byte배열 b의 크기만큼 데이터를 읽어서 배열 b에 저장한다.
				int read(byte[] b) {
					return read(b, 0, b.length)';'
				}
		}
						
		1.4 보조 스트림
		
		언급한 스트림 외에도 스트림의 기능을 보완하기 위한 보조 스트림이 제공 된다.
		보조스트림은 실제 데이터를 주고 받는 스트림이 아니기 때문에 데이터를 입출력할 수 있는 기능은 없지만,
		스트림의 기능을 향상시키거나 새로운 기능을 추가할 수 있다. 그래서 보조 스트림만으로는 입출력 을 처리할 수없고
		스트림을 먼저 생성한 다음에 이를 이용해서 보조 스트림을 생성해야한다.
		예를 들어 test.txt라는 파일을 읽기 위해 FileInputStream을 사용할때, 입력 성능을 향상 시키기 위해
		버퍼를 사용하는 보조 스트림인 BufferdInputStream을 사용하는 코드는 다음과 같다.
		
			// 먼저 기반 스트림을 생성한다.
			FileInputStream fis = new FileInputStream("test.txt");
		
			// 기반 스트림을 이용해서 보조 스트림을 생성한다.
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			bis.read(); // 보조 스트림인 BufferedInputStream으로부터 데이터를 읽는다.
			
		코드상으로는 보조 스트림인 BufferedInputStream 이 입력기능을 수행하는 것처럼 보이지만, 실제
		입력기능은 BufferedInputStream과 연결된 FileInputStream이 수행하고, 보조 스트림인
		 BufferedInputStream은 버퍼만을 제공한다. 버퍼를 사용한 입출력과 사용 하지 않은 입출력간의 성능 차이는 상당하기 때문에 대부분의 경우에 버퍼를 이용한
		 보조 스트림을 사용한다.
		 
		 	입력						출력 					설명
		FilterInputStream	  FilterOutputStream	필터를 이용한 입출력 처리
		BufferedInputStream	  BufferedOutputStream	버퍼를 이용한 입출력 성능 향상
		DataInputStream 	  DataOutputStream 		int, float와 같은 기본형 단위로 데이터를 처리하는 기능
		SequenceInputStream	  없음					두개의 스트림을 하나로 연결
		LineNumberInputStream 없음					읽어온 데이터의 라인 번호를 카운트
		ObjectInputStream	  ObjectOutputStream	데이터를 객체단위로 읽고 쓰는데 사용 주로 파일을 이용하며 객체 직렬화와
													관련되어 있음
		없음 					  PrintStream			버퍼를 이용하며, 추가적인 print와 관련 기능(print, printf, println메서드)
		pushbackInputStream   없음					버퍼를 이용해서 읽어 온 데이터를 다시 되돌리는 기능			
		
		1.5 문자 기반 스트림 - Reader, Writer
		
		지금까지 알아본 스트림은 모두 바이트 기반 의 스트림이었다. 바이트 기반이라함은 입출력 단위가 1byte라는 뜻이다. 이미 알고
		있는 것과 같이 C언어와 달리 Java에서는 한 문자를 의미하는 char 1byte 가 아니라 2 byte이기 때문에 바이트 기반의 스트림으로
		2byte인 문자를 처리하는데는 어려움이 있다.
		
		이점을 보완하기 위해서 문자기반의 스트림이 제공된다. 입출력 할때는 바이트기반 스트림 대신 문자 기반 스트림을 사용하자.
		
						InputStream   ----> Reader
						OutputStream  ----> Writer
		
				바이트 기반 스트림							문자 기반 스트림
			   FileInputStream						     FileReader
			   FileOutputStream							 FileWriter
			   ByteArrayInputStream						CharArrayReader
			   ByteArrayOutputStream				    CharArrayWriter
			   PipedInputStream							PipedReader
			   PipedOutputStream						PipedWriter
			   StringBufferInputStream (deprecated)		StringReader
			   StringBufferOutputStream (deprecated)    StringWriter
			   
			  
		문자 기반 스트림의 이름은 바이트기반 스트림의 이름에서 InputStream은 Reader로 OutputStream은 Writer로
		바꾸면 된다. 단 ByteArrayInputStream에 대응하는 문자 기반 스트림은 char배열을 사용하는 CharArrayReader이다.
	*/
	}
}
