package Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2753 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      BufferedReader rd = new BufferedReader(new InputStreamReader(System.in) );
	      
	      try {
	         int num = Integer.parseInt(rd.readLine());
	         if( (num % 4 == 0 && num % 100 != 0) || (num % 4 == 0 && num % 400 == 0) ) {
	            System.out.printf("%d\n",1);
	         } else {
	            System.out.printf("%d\n",0);
	         }
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }

	}

}
