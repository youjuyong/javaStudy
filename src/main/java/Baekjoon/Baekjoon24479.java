
package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Baekjoon24479 {
   private static List<Integer> list = new ArrayList();
   private static List<Integer> resultList = new ArrayList();
   private static List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
   private static List<Map<String, String>> vertexList = new ArrayList<Map<String, String>>();
   private static List<Map<String, String>> intitNodeList = new ArrayList<Map<String, String>>();
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
      
      
      try {
         StringTokenizer st = new StringTokenizer(rd.readLine());
         
         int nodeCnt = Integer.parseInt(st.nextToken());
         int vertexCnt = Integer.parseInt(st.nextToken());
         int start = Integer.parseInt(st.nextToken());
         
         for ( int i = 0; i < nodeCnt; i++ ) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put( "nodekey" , String.valueOf(i + 1));
            map.put( "search" , false);
            nodeList.add(i, map );
         }
         
         for( int k = 0; k < vertexCnt; k++ ) {
            st = new StringTokenizer(rd.readLine());
            if (st.hasMoreTokens()) {
            	 Map<String, String> map = new HashMap<String, String>();
                 map.put("nodekey", st.nextToken());
                 map.put("vertexNum", st.nextToken());
                 vertexList.add(map);
            }
         }
         
         cycle(start, start);
         
         for ( int i =0; i < nodeList.size(); i++ ) {
        	String test = String.valueOf( nodeList.get(i).get("nodekey"));
        	List<Integer> count = list.stream().filter( v -> String.valueOf(v).equals(test) ).collect(Collectors.toList());
        	if( count.size() > 0 ) {
        		resultList.add(Integer.parseInt(test));
        	} else {
        		resultList.add(0);
        	}
         }
         resultList.stream().forEach(System.out::println);
         rd.close();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
   }
   
   static public void cycle (  int node, int realStart) {
	 String routeCheck =  nodeList.stream().filter(v -> String.valueOf(v.get("nodekey")).equals(String.valueOf(node))).map(v ->String.valueOf( v.get("search"))).collect(Collectors.joining());
	  if ( routeCheck.equals("false") ) {
		  trueNode ( node ); 
		  if ( nextNodeSearch( node ) == 0 ) {
			  cycle(preNodeSearch( node ), realStart);
		  } else {
			  cycle(nextNodeSearch( node ), realStart);
		  }
	  }  
	  
	  if ( routeCheck.equals("true") && node != realStart) {
		  cycle(preNodeSearch( node ), realStart);;
	  } else if ( routeCheck.equals("true") && node == realStart) {
		  return;
	  }
	  
   }
   
   static public int preNodeSearch ( int nodeId ) {
	   int checkStart = vertexList.stream().filter(v ->  String.valueOf(v.get("vertexNum")).equals(String.valueOf(nodeId)) )
             .mapToInt(v ->  Integer.parseInt(v.get("nodekey")) ).max().getAsInt();
	   
	   return checkStart;
   }
   
   static public int nextNodeSearch ( int nodeId ) {
	   int returnValue = 0;
	   int[] nextNode = vertexList.stream().filter(v -> String.valueOf(v.get("nodekey")).equals(String.valueOf(nodeId)) && !(nodeList.stream().filter(vi -> String.valueOf(vi.get("nodekey")).equals(String.valueOf(nodeId))).map(vi -> vi.get("search")).isParallel()) )
             .mapToInt(v ->Integer.parseInt(v.get("vertexNum"))).toArray();
	   
	   if ( nextNode.length > 0 ) {
		   returnValue =  Arrays.stream(nextNode).min().getAsInt();
	   } 
	   
	   return returnValue;
   }
   
   static public void trueNode ( int nodeId ) {
      for ( int i = 0; i < nodeList.size(); i++ ) {
         if ( String.valueOf(nodeList.get(i).get("nodekey")).equals(String.valueOf(nodeId))) {
            nodeList.get(i).remove("search");
            nodeList.get(i).put("search","true");
            list.add(Integer.parseInt((String) nodeList.get(i).get("nodekey")));
         }
      }
   }
   

}