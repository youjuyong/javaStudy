package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon24416 {
	
	static StringBuilder sb = new StringBuilder();
	static long piboCnt = 0L;
	static long dynamicCnt = 0L;
	static long[] memo = new long[50];
	@SuppressWarnings("null")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		  /*문제
	      오늘도 서준이는 동적 프로그래밍 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.

	      오늘은 n의 피보나치 수를 재귀호출과 동적 프로그래밍으로 구하는 알고리즘을 배웠다. 재귀호출에 비해 동적 프로그래밍이 얼마나 빠른지 확인해 보자. 아래 의사 코드를 이용하여 n의 피보나치 수를 구할 경우 코드1 코드2 실행 횟수를 출력하자.

	      피보나치 수 재귀호출 의사 코드는 다음과 같다.

	      fib(n) {
	          if (n = 1 or n = 2)
	          then return 1;  # 코드1
	          else return (fib(n - 1) + fib(n - 2));
	      }
	      피보나치 수 동적 프로그래밍 의사 코드는 다음과 같다.

	      fibonacci(n) {
	          f[1] <- f[2] <- 1;
	          for i <- 3 to n
	              f[i] <- f[i - 1] + f[i - 2];  # 코드2
	          return f[n];
	      }
	      입력
	      첫째 줄에 n(5 ≤ n ≤ 40)이 주어진다.

	      출력
	      코드1 코드2 실행 횟수를 한 줄에 출력한다.
	      */
	      
	      // TODO Auto-generated method stub
	      BufferedReader  rd = new BufferedReader(new InputStreamReader(System.in));
	      BufferedWriter  rw = new BufferedWriter(new OutputStreamWriter(System.out));
	      StringTokenizer st = new StringTokenizer(rd.readLine());
	   
	      
	      int num = Integer.parseInt(st.nextToken());
	      
	      piboCnt += fib(num);
	      dynamicCnt += dynamicFib(num);
	      
	      System.out.println(piboCnt + " " + dynamicCnt);
	      
	      rw.flush();
	      rd.close();
	      rw.close();
	   }
	   
	   static int fib(int num) {
	      
	      if ( num == 1 || num == 2 ) {
	         return 1;
	      } else {
	         return (fib( num - 1) + fib( num - 2 )); 
	      }
	   }
	   
	   static long dynamicFib(int num) {
	      long cnt = 0;
	      
	      memo[1] = 1;
	      memo[2] = 1;
	      memo[5] = memo[4] + memo[3];
	      for ( int i = 3; i <= num; i ++) {
	         cnt++;
	         memo[i] = memo[i - 1] + memo[i - 2];
	      }
	      
	      return cnt;
	   }

}
