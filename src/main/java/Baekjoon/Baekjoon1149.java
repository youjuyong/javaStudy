package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon1149 {

	public static void main(String[] args) throws IOException {
	     
	      /*문제
	         RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
	   
	         집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
	   
	         1번 집의 색은 2번 집의 색과 같지 않아야 한다.
	         N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
	         i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
	         입력
	         첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.
	   
	         출력
	         첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
	      */
	      
	      BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	      BufferedWriter rw = new BufferedWriter(new OutputStreamWriter(System.out));
	      
	      StringTokenizer st;
	      st = new StringTokenizer(rd.readLine());
	      int houseCnt = Integer.parseInt(st.nextToken());
	      
	      int[][] houseArr = new int[houseCnt+1][3];
	      int[] resultArr = new int[3];
	      
	      for ( int i = 1; i <= houseCnt; i++ ) {
	         st = new StringTokenizer(rd.readLine());
	         
	         for ( int z = 0; z < 3; z++ ) {
	            houseArr[i][z] = Integer.parseInt(st.nextToken());
	         }
	         
	      }
	      
	      for ( int i = 1 ; i < houseArr.length; i++ ) {
	            int num1 = Math.min(houseArr[i][0]+ houseArr[i-1][1],houseArr[i][0]+ houseArr[i-1][2]);
	            int num2 = Math.min(houseArr[i][1]+ houseArr[i-1][0],houseArr[i][1]+ houseArr[i-1][2]);
	            int num3 = Math.min(houseArr[i][2]+ houseArr[i-1][0],houseArr[i][2]+ houseArr[i-1][1]);
	            
	            resultArr[0] = num1;
	            resultArr[1] = num2;
	            resultArr[2] = num3;
	            
	            houseArr[i][0] = num1;
	            houseArr[i][1] = num2;
	            houseArr[i][2] = num3;
	      }
	      
	      int result1 = Math.min(resultArr[0],resultArr[1]);
	      int result2 = Math.min(result1,resultArr[2]);
	      
	      System.out.println(result2);

	}

}
