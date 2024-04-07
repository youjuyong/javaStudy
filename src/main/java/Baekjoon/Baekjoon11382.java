package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Baekjoon11382 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		long sum = 0;
		try {
			String[] strArr = rd.readLine().split(" ");
			for( int i = 0; i < strArr.length; i++) {
				sum += Long.parseLong(strArr[i]);
			}
			System.out.printf("%d",sum);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
