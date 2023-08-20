package com.CollectionsStudy;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 1. 컬렉션 프레임웍 ( Collections Framework )
			1.1 컬렉션 프레임 웍의 핵심 인터페이스
			
			컬렉션 프레임 웍에서는 컬렉션 데이터 그륩을 3가지 타입이 존재한다고 인식하고 각 컬렉션을
			다루는데 필요한 기능을 가진 3개의 인터페이스를 정의 하였다. 그리고 인터페이스 List 와 Set의
			공통된 부분을 다시 뽑아서 새로운 인터페이스인 Collection을 추가로 정의 하였다.
			
				Collection
			     |       |				Map
			   List		Set
			
			   컬렉션 프레임의 핵심 인터페이스간의 상속 계층도
		인터페이스 List와 Set을 구현한 컬렉션 클래스들은 서로 많은 공통 보분이 있어서 공통된
		부분을 다시 뽑아 Collection인터페이스를 정의 할수 있었지만 Map 인터페이스는 이 들과는
		전혀 다른 형태로 컬렉션을 다루기 때문에 같은 상속 계층도에 포함되지 못했다.
		
		컬렉션 프레임웍의 핵심 인터페이스와 특징
		
		(1) List : 순서가 있는 데이터의 집합, 데이터의 중복을 허용한다.
		구현 클래스 : ArrayList, LinkedList, Stack, Vector
		
		(2) Set : 순서를 유지 하지 않는 데이터의 집합, 데이터의 중복을 허용하지 않는다.
		구현 클래스 : HashSet, TreeSet
		
		(3) Map : 키(Key)와 값(value)의 쌍(pair)으로 이루어진 데이터의 집합
		순서는 유지 되지 않으며, 키는 중복을 허용하지 않고, 값은 중복을 허용한다.
		구현클래스 HashMap, TreeMap, Hashtable, Properties 등
		
 ---------------------------------------------------------------------------------------------------------------
		1. Collection 인터페이스
		
		List와 Set의 조상인 Collection 인터페이스는 다음과 같은 메소드들이 정의되어 있다.
			
			* 메서드 							          설명
			
		boolean add(Object o)            : 지정된 객체(o) 또는 Collection(c)의 객체들을 Collection에 추가한다.
		boolean addAll(Collection c) 
		
		void claear()                    : Collection의 모든 객체를 삭제한다.
		
		boolean contains(Object o)   	 : 지정된 객체(o) 또는 Collection의 객체들이 Collection에 포함되어 있는지
		boolean containsAll(Collection C)  확인한다.
		
		boolean equals(Object o)         : 동일한 Collection인지 비교한다.
		
		int hashCode()                   : Collection의 hash code를 반환한다.
		
		boolean isEmpty()                : Collection이 비어있는지 확인한다.
		
		Iterator iterator()              : Collection의 Iterator를 얻어서 반환한다.
		
		boolean remove(Object o)         : 지정된 객체를 삭제 한다.
		
		boolean removeAll(Collection c)  : 지정된 Collection에 포함된 객체들을 삭제한다.
		
		boolean retainAll(Collection c)  : 지정된 Collection에 포함된 객체 만을 남기고 다른 객체들은 Collection에서 삭제 한다.
										   이작업으로 인해 Collection에 변화가 있으면 true 그렇지 않으면 false를 반환한다.
								
		int size()                       : Collection에 저장된 객체의 개수를 반환한다.
		
		Object[] toArray()               : Collection에 저장된 객체를 객체배열(Object[])로 반환한다.
		
		Object[] toArray(Object[] a)     : 지정된 배열에 Collection의 객체를 저장해서 반환한다.
		
-----------------------------------------------------------------------------------------------------------------
		List 인터페이스 
		
		List 인터페이스는 중복을 허용하면서 저장순서가 유지되는 컬렉션을 구현하는데 사용된다.
		
				  List
		    /        |        \
		Vector    ArrayList  LinkedList  
		  |
		Stack
				
				List의 상속 계층도
				
		2. List 인터페이스
		
			* 메서드									* 설 명
		
		void add(int index, Object element)      : 지정된 위치(index)에 객체(element) 또는 컬렉션에 포함된 객체들을 추가한다.
		boolean addAll(int index, Collection c)
		
		Object get(int index)                    : 지정된 위치(index)에 있는 객체를 반환 한다.
		
		int lastIndexOf(Object o)                : 지정된 객체의 위치(index)를 반환한다.
		
		ListIterator listIterator()              : List의 객체에 접근할 수 있는 ListIterator를 반환한다.
		ListIterator listIterator( int index )  
		
		Object remove( int index )               : 지정된 위치( index ) 에 있는 객체를 삭제하고 삭제된객체를
												  반환한다.
		
		Object set (int index, Object element )  : 지정된 위치 (index) 에 객체(element) 를 저장한다.
		
		void sort (Comparator c)                 : 지정된 비교자(comparator)로 List를 정렬 한다.
		
		List subList(int fromIndex, int toIndex) : 지정된 범위 (fromIndex 부터 toIndex)에 있는 객체를 반환한다.
		
		
-----------------------------------------------------------------------------------------------------

		3. Set 인터페이스 
		
		Set 인터페이스는 중복을 허용 하지 않고 저장순서가 유지되지 않는 컬렉션 클래스를 구현 하는데 사용된다.
		Set 인터페이스를 구현한 클래스로 HashSet, TreeSet 등이 있다.
		
			       Set
			   /	|
		HashSet  SortedSet
					|
				  TreeSet
				  
		4. Map 인터페이스
		
		Map 인터페이스는 키(key) 값(value) 을 하나의 쌍으로 묶어서 저장하는 컬렉션 클래스를 구현하는데 사용된다.
		키는 중복될수 없지만 값은 중복 허용한다. 기존에 저장된 데이터와 중복된 키와 값을 저장하면 기존 값은 없어지고 마지막에 저장된
		값이 남게 된다.
		Map 인터페이스를 구현한 클래스로는 Hashtable, HashMap, LinkedHashMap,
		SortedMap, TreeMap 등이 있다.
		
					Map
			/        |        \
		Hashtable  HashMap    SortedMap
					 |           |
				LinkedHashMap  TreeMap
		
		
		   * 메서드                                   * 설 명
		
		void clear()                         :  Map의 모든 객체를 삭제한다.
		
		boolean containsKey(Object key)      :  지정된 key객체와 일치하는 Map의 Key객체가 있는지 확인한다.
		boolean containsValue(Object value)  :  지정된 value객체와 일치하는 Map의 value 객체가 있는지 확인한다.
		
		Set entrySet()                       :  Map에 저장되어 있는 key-value 쌍을 Map.Entry 타입의 객체로 저장한 Set으로
											  변환한다.
		
		boolean equals(Object c)             : 동일한 Map인지 비교한다.
		
		Object get ( Object key )            : 지정한 Key 객체에 대응하는 value 객체를 찾아서 반환한다.
		
		int hashCode()                       : 해시코드를 반환한다.
		
		boolean isEmpty()                    : Map이 비어있는지 확인한다.
		
		Set keySet()                         : Map에 저장된 모든 key 객체를 반환한다.
		
		Object put(Object key, Object value) : Map에 value 객체를 key객체에 연결(mapping) 하여 저장한다.
		
		void putAll(Map t)                   : 지정된 Map의 모든 key-value쌍을 추가한다.
		
		Object remove(Object key)            : 지정한 객체와 일치하는 key-value를 삭제한다.
		
		int size()                           : Map에 저장된 key - value쌍의 개수를 반환한다.
		
		Collection values()                  : Map에 저장된 모든 value 객체를 반환한다.
		
		1.2 ArrayList
		
		ArrayList는 컬렉션 프레임 웍에서 가장 많이 사용되는 컬렉션 클래스이다.
		ArrayList는 List인터 페이스를 구현하기 때문에 데이터의 저장순서가 유지되고 중복을 하용한다는 특징을 갖는다.
		ArrayList는 기존의 Vector를 개선한 것으로 Vector와 구현 원리와 기능적인 측면에서는 동일하다고 볼수있다
		ArrayList는 Object배열을 이용해서 데이터를 순차적으로 저장한다. 예를 들어 첫번째로 저장한 객체는 Object
		배열의 0번째 위치에 저장되고 그 다음에 저장하는 객체는 1번 째위치에 저장된다. 이런식으로 계속 배열에 순서대로 저장되며 배열에
		더 이상 저장할 공간이 없으면 보다 큰 새로운 배열을 생성해서 기존의 배열에 저장된 내용을 새로운 배열로 복사한 다음에 저장한다.
		
		메서드							설명
		ArrayList()   							 크기가 10인 ArrayList를 생성
		ArrayList(Collection c)      			 주어진 컬렉션이 저장된 ArrayList생성
		ArrayList(int initialCapacity)			 지정된 초기 용량을 갖는 ArrayList를 생성
		boolean add( Object o )					 ArrayList의 마지막에 객체를 추가, 성공하면 true
		void add(int index,Object element)		 지정된 위치(index) 객체 생성
		boolean addAll(Collection c)			 주어진 컬렉션의 모든 객체를 저장한다.
		boolean addAll(int index, Collection c)  지정된 위치부터 주어진 컬렉션의 모든 객체를 저장한다.
		void clear()          					 ArrayList를 완전히 비운다.
		Object clone()							 ArrayList를 복제한다.
		boolean contains (Object o)				 지정된 객체 (o)가 ArrayList에 포함 되는지 확인
		void ensureCapacity(int minCapacity)	ArrayList의 용량이 최소한 minCapacity가 되도록 한다.
		Object get(int index)					지정된 위치(index)에 저장된 객체를 반환한다.
		int indexOf(Object o)					지정된 객체가 저장된 위치를 찾아 반환한다.
		boolean isEmpty()						ArrayList가 비었는지 확인한다.
		Iterator iterator()						ArrayList의 Iterator 객체를 반환.
		int lastIndexOf(Object o)				ArrayList의 ListIterator를 반환
		ListIterator listIterator(int index) 	ArrayList의 지정된 위치부터 시작하는 ListIterator를 반환
		Object remove(int index)				지정된 위치(index)에 있는 객체를 제거한다.
		boolean removeAll(Collection c) 		지정한 컬렉션에 저장된 것과 동일한 객체들을 ArrayList에서 제거한다.
		boolean retainAll(Collection c) 		ArrayList에 저장된 객체 중에서 주어진 컬렉션과 공통된 것을만 남기고 나머지는 삭제
		Object set(int index, Object element)   주어진 객체(element)를 지정된 위치에 저장한다.
		int size()								ArrayList에 저장된 객체의 갯수를 반환한다.
		void sort(Comparator c)					지정된 정렬기준 (c)으로 ArrayList를 정렬
		Object[] toArray() 						ArrayList에 저장된 모든 객체를 객체 배열로 반환한다.
		Obejct[] toArray(Object[] a) 			ArrayList에 저장된 모든 객체들을 객체 배열 a에 담아 반환한다.
		void trimToSize()						용량을 크기에 맞게 줄인가. (빈공간을 없앤다)
		*/
		
		ArrayList list1 = new ArrayList(10);
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(3));
		list1.add(new Integer(2));
		list1.add(new Integer(1));
		
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		print(list1, list2);
		
		Collections.sort(list1); // 정렬
		Collections.sort(list2); // 정렬
		print(list1, list2);		
		
		System.out.println("list1.containsAll(list2):" + list1.containsAll(list2));
		
		list2.add("B");
		list2.add("C");
		list2.add(3,"A");
		
		print(list1, list2);
		
		list1.set(3, "A");
		print(list1, list2);
		
		System.out.println("list1.retainAll(list2) : " + list1.retainAll(list2));
		
		print(list1, list2);
		for(int i = list2.size()-1; i >= 0; i--) {
			if(list1.contains(list2.get(i))) {
				list2.remove(i);
			}
		}
		
		print(list1, list2);
	}
	
	static void print (ArrayList list1, ArrayList list2) {
		System.out.println("============================");
		System.out.println("list1:"+list1);
		System.out.println("list2:"+list2);
	}

}
