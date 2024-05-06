package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon2941 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter wd = new BufferedWriter(new OutputStreamWriter(System.out));
      StringBuilder sb = new StringBuilder();
      
      String[] lan_arr = new String[] {"c=","c-","dz=","d-","lj","nj","s=","z="};
      int result = 0; 
      
      try {
      
         sb.append(rd.readLine());
         for ( int i = 0; i < lan_arr.length; i ++ ) {
            String lan = lan_arr[i];
            
             int faccnt = 0;
             result += factorial(sb, lan, faccnt);
             
         }
         
         System.out.println(result + sb.toString().replace(" ", "").length());
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      
   }
   
   public static int factorial (StringBuilder sb, String lan, int cnt) {
      
      int index = sb.indexOf(lan);
      
      if ( index != -1 ) {
         sb.delete(index, (index +  lan.length()));
         for ( int i = index ; i <  (index +  lan.length()); i++ ) {
        	 sb.insert(i, " ");
         }
         return factorial(sb, lan, cnt + 1);
      } else {
         return cnt;
      }
   }

}