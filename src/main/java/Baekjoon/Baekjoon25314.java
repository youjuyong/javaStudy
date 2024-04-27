package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon25314 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 입력 첫 번째 줄에는 문제의 정수 N이 주어진다. N은 4의 배수
		 * 
		 * 출력 혜아가 N바이트 정수까지 저장할 수 있다고 생각하는 정수 자료형의 이름을 출력하여라.
		 * 
		 * 예제 입력 1 4 예제 출력 1 long int
		 */
		
			BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
			
			StringBuffer sb = new StringBuffer();
			
			try {
				int input = Integer.parseInt(rd.readLine()) / 4;
				
				for(int i = 0; i < input; i++ ) {
					sb.append("long ");
				}
				sb.append("int");
				System.out.println(sb.toString());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
