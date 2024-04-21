package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Baekjoon10950 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 문제 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
		 * 
		 * 입력 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
		 * 
		 * 각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
		 * 
		 * 출력 각 테스트 케이스마다 A+B를 출력한다.
		 */
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		
		
		try {
			int cnt = Integer.parseInt(rd.readLine());
			int[] sumArr = new int[cnt];
			
			for ( int i = 0; i < cnt; i++ ) {
				String[] rdArr = rd.readLine().split(" ");
				int sum = Integer.parseInt(rdArr[0]) + Integer.parseInt(rdArr[1]);
				sumArr[i] = sum;
			}
			
			for ( int result : sumArr) {
				System.out.println(result);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
