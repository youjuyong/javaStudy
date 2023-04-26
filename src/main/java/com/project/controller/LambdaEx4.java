package com.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LambdaEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1.4 java.util.function 패키지
		
		// java.util.function 패키지에 일반적으로 자주 쓰이는 형식의 메서드를 함수형 인터페이스로 미리 정의해
		// 놓았다. 매번 새로운 함수형 인터페이스를 정의하지 않아도 되고 재사용성이나 유지보수 측면에서 좋다.
		
		/*
		 *  자주 사용되는 함수형 인터페이스는 다음과 같다. 1. java.lang.Runnable , 메서드 : void() 매개 변수도 없고
		 *  반환값도 없음 2. Supplier<T> , 메서드 : get() -> T 매개변수는 없고 반환값만 있음 3. Consumer<T> ,
		 *  메서드 : -> T void accept(T t) Supplier 와 반대로 매개변수만 있고, 반환값이 없음 4. Function<T,R>
		 *  , 메서드 : -> T R apply(T t) -> R 일반적인 함수, 하나의 매개변수를 받아서 결과를 반환 5. Predicate<T>
		 *  , 메서드 : -> T boolean test(T t) -> boolean 조건식을 표현하는데 사용됨 매개변수는 하나 반환타입은
		 *  boolean
		 * 
		 *  매개변수와 반환값의 유무에 따라 4개의 함수형 인터 페이스가 정의되어 있고 Function의 변형으로 Predicate가 있는데, 반환값이
		 *  boolean이라는 것만 제외하면 Function과 동일하다. Predicate는 조건식을 함수로 표현하는데 사용된다. ## 타입문자 T는
		 *  타입, R은 Return을 의미
		*/
		
		/*
		 *  ※조건식의 표현에 사용되는 Predicate 
		 *  
		 *  Predicate는 Function의 변형으로 , 반환 타입이 boolean이라는 것만 다르다.
		 *  Predicate는 조건식을 람다식으로 표현 하는데 사용된다.
		 * 
		 *  Predicate<String> isEmptStr = s -> s.length() == 0; String s = "";
		 * 
		 *  if(isEmptyStr.test(s)) // if(s.length() == 0)
		 *  System.out.println("This is an empty String.");
		 */
		
		/*
		 *  ※매개 변수가 두개인 함수형 인터 페이스 매개 변수가 2개인 함수형 인터페이스는 이름앞에 접두사 'Bi'가 붙는다.
		 * 
		 *  Biconsumer<T,U> -> T,U void accept(T t, U u) 두개의 매개변수만 있고 반환값 없음
		 *  BiPredicate<T,U> -> T,U boolean test(T t, U u) -> boolean 조건식을 표현하는데 사용됨
		 *  매개변수둘, 반환값 boolean BiFunction<T,U,R> -> T,u R apply(T t, U u) -> 두개의 매개변수를
		 *  받아서 하나의 결과값 반환.
		 */
		
		/*
		 *  ※컬렉션 프레임 워크와 함수형 인터페이스 
		 *  컬렉션 프레임 웍의 인터페이스에 다수의 디폴트 메서드가 추가되었는데, 그중 일부는 함수형
		 *  인터페이스를 사용한다.
		 * 
		 *  인터페이스 메서드 설명 Collection -> boolean removeif (Predicate<E> filter) 조건에 맞는 요소를
		 *  삭제 List -> void replaceAll (UnaryOperater<E> operater) 모든 요소를 변환 하여 대체
		 *  Iterable -> void forEach(Consumer<T> action) 모든 요소에 작업 action 수행 Map -> V
		 *  compute (K key,BiFunction<K,V,V> f) 지정된 키의 값에 작업 f를 수행 -> V computeIfAbsent(K
		 *  key, Function<K,V> f) 키가 없으면, 작업 f 수행후 추가 -> V merge (K key, V value,
		 *  BiFunction<V,V,V> f) 모든 요소에 병합 작업 f 수행 -> void forEach(BiConsumer<K,V>
		 *  action) 모든 요소에 작업 action 수행 -> void replaceAll(BiFunction<K,V,V> f) 모든 요소에 치환
		 *  작업 f를 수행
		 * 
		 *  Map 인터페이스에 있는 compute로 시작하는 메서드들은 맵의 value를 변환 하는 일을 하고 merge()는 Map을 병합 하는
		 *  일을 한다.
		 */
		
		ArrayList<Integer> list = new ArrayList();
		for(int i = 0; i < 10; i++) 
			list.add(i);
		
		// list의 모든 요소를 출력
		list.forEach(i -> System.out.print(i + ","));
		System.out.println();
		
		// list에서 2 또는 3의 배수를 제거한다.
		list.removeIf(x -> x % 2 == 0 || x % 3== 0);
		System.out.println(list);
		
		list.replaceAll(i->i*10); // list의 각 요소에 10을 곱한다.
		System.out.println(list);
		
		Map<String,String> map = new HashMap();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		
		// map의 모든 요소를 {k, v}의 형식으로 출력한다.
		map.forEach((k,v) -> System.out.print("{"+k+","+v+"},"));
		System.out.println();
	
		// 출력결과
		// 0,1,2,3,4,5,6,7,8,9,
		// [1, 5, 7]
		// [10, 50, 70]
		// {1,1},{2,2},{3,3},{4,4},

	}

}
