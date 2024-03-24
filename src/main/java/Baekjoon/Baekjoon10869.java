package Baekjoon;

import java.util.Scanner;

public class Baekjoon10869 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 문제 두 자연수 A와 B가 주어진다. 이때, A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 프로그램을 작성하시오.
		 * 
		 * 입력 두 자연수 A와 B가 주어진다. (1 ≤ A, B ≤ 10,000)
		 * 
		 * 출력 첫째 줄에 A+B, 둘째 줄에 A-B, 셋째 줄에 A*B, 넷째 줄에 A/B, 다섯째 줄에 A%B를 출력한다.
		 */
		Scanner sc = new Scanner(System.in);
		
		String[] input = sc.nextLine().split(" ");
		System.out.println(Integer.parseInt(input[0]) + Integer.parseInt(input[1]));
		System.out.println(Integer.parseInt(input[0]) - Integer.parseInt(input[1]));
		System.out.println(Integer.parseInt(input[0]) * Integer.parseInt(input[1]));
		System.out.println(Integer.parseInt(input[0]) / Integer.parseInt(input[1]));
		System.out.println(Integer.parseInt(input[0]) % Integer.parseInt(input[1]));
	}

}
