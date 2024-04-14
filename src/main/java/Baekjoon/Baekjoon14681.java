package Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Baekjoon14681 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		   
		   try {
		      int num1 = Integer.parseInt(rd.readLine());
		      int num2 = Integer.parseInt(rd.readLine());
		      
		      if ( num1 > 0 && num2 > 0 ) {
		         System.out.println("1");
		      } else if ( num1 > 0 && num2 < 0 ) {
		         System.out.println("4");
		      } else if ( num1 < 0 && num2 > 0 ) {
		         System.out.println("2");
		      } else {
		         System.out.println("3");
		      }
		   } catch (NumberFormatException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		   } catch (IOException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		   }

	}

}
