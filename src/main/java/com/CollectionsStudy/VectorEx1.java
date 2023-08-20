package com.CollectionsStudy;

import java.util.ArrayList;
import java.util.Vector;

public class VectorEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vector v = new Vector(5); // 용량 (capacity)이 5인 Vector를 생성한다.
		v.add("1");
		v.add("2");
		v.add("3");
		print(v);
		
		v.trimToSize(); // 용량과 크기가 같아진다
		System.out.println("=== After trimTosize() ===");
		print(v);
		
		v.ensureCapacity(6);
		System.out.println("=== After ensureCapacity(6) ===");
		print(v);
		
		v.setSize(7);
		System.out.println("=== After setSize(7) ===");
		print(v);
		
		v.clear();
		System.out.println("=== After clear() ===");
		print(v);
		
		/*
		[1, 2, 3]
		size : 3
		capacity : 5
		=== After trimTosize() ===
		[1, 2, 3]
		size : 3
		capacity : 3
		=== After ensureCapacity(6) ===
		[1, 2, 3]
		size : 3
		capacity : 6
		=== After setSize(7) ===
		[1, 2, 3, null, null, null, null]
		size : 7
		capacity : 12
		=== After clear() ===
		[]
		size : 0
		capacity : 12
		*/
		
		/*
		 * ArrayList나 Vector 같이 배열을 이용한 자료구조는 데이터를 읽어 오고 저장하는데는 효율일 좋지만
		 * 용량을 변경해야할 때는 새로운 배열을 생성한 후 기존의 배열로 부터 새로 생성된 배열로 데이터를 복사해야하기 때문에
		 * 상당히 효율이 떨어진다는 단점을 가지고 있다. 그래서 처음에 인스턴스를 생성할 때, 저장할 데이터의 개수를 잘 고려하여
		 * 충분한 용량의 인스턴스를 생성하는 것이 좋다.
		 * 
		 * 
		 * 
		 */
	}
	
	public static void print (Vector v) {
		System.out.println(v);
		System.out.println("size : " + v.size());
		System.out.println("capacity : " + v.capacity());
	}
}
