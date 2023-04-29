package com.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Supplier<Integer>  s = () -> (int)(Math.random()*100) + 1;
		Consumer<Integer>  c = i  -> System.out.print(i +", ");
		Predicate<Integer> p = i  -> i % 2 == 0;
		Function<Integer, Integer> f = i -> i/10 * 10; // i의 일의 자리를 없앤다.
		
		List<Integer> list = new ArrayList<>();
		
		makeRandomList(s, list);
		System.out.println(list);
		printEvenNum(p, c, list);
		List<Integer> newList = doSomething(f, list);
		System.out.println(newList);
	}
	
	static <T> void makeRandomList(Supplier<Integer> s, List<Integer> list) {
		for(int i =0; i < 10; i++) {
			list.add(s.get());
		}
	}
	
	// i가 짝수인것을 Consumer로 반환해서 표출
	static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
		System.out.println("[");
		for(T i : list) {
			if(p.test(i))
				c.accept(i);
		}
		System.out.println("]");
	}

	static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
		List<T> newList
		= new ArrayList<T>(list.size());
		
		for(T i : list) {
			newList.add(f.apply(i));
		}
		return newList;
	}
	
	
}
