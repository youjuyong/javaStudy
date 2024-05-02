package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BaekJoon2439 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 문제 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
		 * 
		 * 하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.
		 * 
		 * 입력 첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
		 * 
		 * 출력 첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
		 */
		
	      BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	      BufferedWriter wd = new BufferedWriter(new OutputStreamWriter(System.out));
	      
	      int cnt;
	      try {
	         cnt = Integer.parseInt(rd.readLine());
	         
	         for( int i = 1; i <= cnt; i++ ) {
	            
	            for( int k = 1; k <= cnt; k++ ) {
	            
	               if( k > cnt - i) {
	                  wd.write("*");
	               } else {
	                  wd.write(" ");
	               }
	            }
	            wd.flush();
	            System.out.println();
	         }
	         rd.close();
	         
	         wd.close();
	      } catch (NumberFormatException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	}

}
