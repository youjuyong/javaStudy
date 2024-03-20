package Baekjoon;

import java.util.Scanner;

public class Baekjoon10098 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 문제 두 정수 A와 B를 입력받은 다음, A×B를 출력하는 프로그램을 작성하시오.
		 * 
		 * 입력 첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)
		 * 
		 * 출력 첫째 줄에 A×B를 출력한다.
		 */
		
		
		Scanner sc = new Scanner(System.in);
		
		String[] input = sc.nextLine().split(" ");
		System.out.printf("%d",Integer.parseInt(input[0]) * Integer.parseInt(input[1]));
	}

}
