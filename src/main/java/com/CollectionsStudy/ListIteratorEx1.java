package com.CollectionsStudy;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		
		ListIterator it = list.listIterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
		
		while(it.hasPrevious()) {
			System.out.println(it.previous());
		}
		System.out.println();
	}

}
