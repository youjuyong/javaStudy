package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9498 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
				
		int num = 0;;
		String score = "";
		try {
			num = Integer.parseInt(rd.readLine());
			
			if( num >= 90 && num <= 100) {
				score = "A";
			} else if ( num >= 80 && num < 90 ) {
				score = "B";
			} else if ( num >= 70  && num < 80 ) {
				score = "C";
			} else if ( num >= 60  && num < 70 ) {
				score = "D";
			} else {
				score = "F";
			}
			System.out.println(score);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
