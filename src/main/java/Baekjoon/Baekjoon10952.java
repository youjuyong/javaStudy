package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon10952 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 문제 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
		 * 
		 * 입력 입력은 여러 개의 테스트 케이스로 이루어져 있다.
		 * 
		 * 각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
		 * 
		 * 입력의 마지막에는 0 두 개가 들어온다.
		 * 
		 * 출력 각 테스트 케이스마다 A+B를 출력한다.
		 */
		  BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	      BufferedWriter wd = new BufferedWriter(new OutputStreamWriter(System.out));
	      
	      StringTokenizer st;
	      boolean check = true;
	      
	      try {
	         
	         
	         while (check) {
	            st = new StringTokenizer(rd.readLine()," ");
	            int num1 = Integer.parseInt(st.nextToken());
	            int num2 = Integer.parseInt(st.nextToken());
	            
	            if( num1 == 0 && num2 == 0) {
	               rd.close();
	               wd.close();
	               check = false;
	            } else {
	               int sum = num1 + num2;
	               wd.write(String.valueOf(sum) + "\n");
	               wd.flush();
	            }
	         }
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	}

}
