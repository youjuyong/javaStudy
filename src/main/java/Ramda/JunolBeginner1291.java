package Ramda;

import java.util.Scanner;

public class JunolBeginner1291 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 원하는 구구단의 범위를 입력받아 해당 구간의 구구단을 출력하는 프로그램을 작성하시오.
		 * 
		 * [처리조건]
		 * (1) 구간의 처음과 끝을 입력받는다.
		 * (2) 입력된 구간은 반드시 처음 입력 값이 끝의 입력 값보다 작아야 하는 것은 아니다.
		 * 즉, 입력된 구간의 범위는 증가하거나 감소하는 순서 그대로 출력되어야 한다.​
		 * 입력 구구단의 시작 범위 s,와 끝 범위 e를 입력받는다.(s와 e는 2부터 9사이의 정수)
		 * 하나의 결과가 출력되면 프로그램을 종료한다.
		 * 출력 시작 범위와 끝 범위사이의 구구단을 출력하되 모든 값과 부호 사이는 공백으로 구분하여 아래 출력 예와 같이 줄을 맞추어 출력해야
		 * 한다.
		 * 구구단 사이는 3개의 공백으로 구분한다.
		 * 데이터의 크기가 주어진 범위를 벗어날 경우는 "INPUT ERROR!"를 출력하고 s와 e를 다시 입력받는다.
		 */
		
		Scanner in = new Scanner(System.in);
		boolean check = false;
		while(!check) {
			String[] N = in.nextLine().split(" ");
				int is1 = Integer.parseInt(N[0]);
				int is2 = Integer.parseInt(N[1]);
				if( (is1 < 2 || is1 > 9) || (is2 < 2 || is2 > 9) ) {
					System.out.println("INPUT ERROR!");
				} else {
					for( int j = 1; j < 10; j++) {
						if( is1 < is2 ) {
							for(int i = is1; i <=  is2; i++) {
								System.out.printf("%d * %d = %2d",i,j, ( i * j ) );
								System.out.print(" ");
								System.out.print(" ");
								System.out.print(" ");
							}
						} else if( is1 > is2 ) {
							for(int i = is1; i >=  is2; i--) {
								System.out.printf("%d * %d = %2d",i,j, ( i * j ) );
								System.out.print(" ");
								System.out.print(" ");
								System.out.print(" ");
							}
						} else if( is1 == is2 ) {
								System.out.printf("%d * %d = %2d",is1 ,j, ( is1 * j ) );
								System.out.print(" ");
								System.out.print(" ");
								System.out.print(" ");
						}
						System.out.println("");
					}
					check = true;
				}
		}
	}

}
