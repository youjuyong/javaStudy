package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1932 {

	public static void main(String[] args) throws IOException {
		
		/*
		 * 문제
			        7
			      3   8
			    8   1   0
			  2   7   4   4
			4   5   2   6   5
		 * 위 그림은 크기가 5인 정수 삼각형의 한 모습이다.
		 * 
		 * 맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 이제까지 선택된 수의 합이 최대가 되는 경로를 구하는
		 * 프로그램을 작성하라. 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.
		 * 
		 * 삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.
		 * 
		 * 입력 첫째 줄에 삼각형의 크기 n(1 ≤ n ≤ 500)이 주어지고, 둘째 줄부터 n+1번째 줄까지 정수 삼각형이 주어진다.
		 * 
		 * 출력 첫째 줄에 합이 최대가 되는 경로에 있는 수의 합을 출력한다.
		 */
		// TODO Auto-generated method stub
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      
	      StringTokenizer st;
	      
	      st = new StringTokenizer(br.readLine());
	      
	      int triCnt = Integer.parseInt(st.nextToken());
	      
	      int[][] triArr = new int[triCnt + 1][triCnt + 1];
	      
	      for ( int i = 1; i <= triCnt; i++ ) {
	         st = new StringTokenizer(br.readLine());
	         
	         for ( int z = 1; z <= i; z++ ) {
	            
	            int inputNum = Integer.parseInt(st.nextToken());
	            int maxRowNum = Math.max( triArr[i-1][z] + inputNum, triArr[i - 1][z - 1] + inputNum );
	            triArr[i][z] = maxRowNum;
	            
	         }
	      }
	      
	      List<Integer> list = new ArrayList<Integer>();
	      
	      for ( int i = 1; i <= triCnt; i++ ) {
	         list.add(triArr[triCnt][i]) ;
	      }
	      
	      System.out.println(Collections.max(list));

	}

}
