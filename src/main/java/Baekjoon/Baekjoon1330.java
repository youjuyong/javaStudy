package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1330 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 문제 두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.
		 * 
		 * 입력 첫째 줄에 A와 B가 주어진다. A와 B는 공백 한 칸으로 구분되어져 있다.
		 * 
		 * 출력 첫째 줄에 다음 세 가지 중 하나를 출력한다.
		 * 
		 * A가 B보다 큰 경우에는 '>'를 출력한다. A가 B보다 작은 경우에는 '<'를 출력한다. A와 B가 같은 경우에는 '=='를 출력한다.
		 */
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] str = rd.readLine().split(" ");
			int num1 = Integer.parseInt(str[0]);
			int num2 = Integer.parseInt(str[1]);
			
			if( num1 > num2 ) {
				System.out.println(">");
			} else if ( num1 < num2 ) {
				System.out.println("<");
			} else {
				System.out.println("==");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
