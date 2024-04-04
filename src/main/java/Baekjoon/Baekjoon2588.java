package Baekjoon;

import java.util.Scanner;

public class Baekjoon2588 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 문제 (세 자리 수) × (세 자리 수)는 다음과 같은 과정을 통하여 이루어진다.
		 * 
		 * 
		 * 
		 * (1)과 (2)위치에 들어갈 세 자리 자연수가 주어질 때 (3), (4), (5), (6)위치에 들어갈 값을 구하는 프로그램을 작성하시오.
		 * 
		 * 입력 첫째 줄에 (1)의 위치에 들어갈 세 자리 자연수가, 둘째 줄에 (2)의 위치에 들어갈 세자리 자연수가 주어진다.
		 * 
		 * 출력 첫째 줄부터 넷째 줄까지 차례대로 (3), (4), (5), (6)에 들어갈 값을 출력한다.
		 */
		
		Scanner sc1 = new Scanner(System.in);
		int num = sc1.nextInt();
		sc1.nextLine();
		String[] input = sc1.nextLine().split("");
		
		int sum = 0;
		
		for( int i = input.length - 1; i >= 0; i--) {
			int n = num * Integer.parseInt(input[i]);
			System.out.println(n);
			sum += (int)Math.floor(n * Math.pow(10, input.length - i -1));
		}
		System.out.printf("%d\n",sum);
	}

}
