package com.progect.Generics;

import java.util.ArrayList;

class Fruit { 
		public String toString() {
			return "Fruit"; 
		}
}

class Apple extends Fruit {
		public String toString() {
			return "Apple";
		}
}

class Grape extends Fruit {
		public String toString() {
			return "Grape";
		}
}

class Toy {
	public String toString() {
			return "Toy";
	}
}

public class GenericsFruitBoxEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	 /* 1. 지네릭스(Generics)
		JDK 1.5에서 처음 도입된 지네릭스는 JDK 1.8부터 도입된 람다식만큼 큰변화 였다.
		
		1.1 지네릭스란?
				
		지네릭스는 다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에 컴파일 시의 타입 체크(compile-time type check)를
		해주는 기능이다. 객체의 타입을 컴파일시에 체크 하기 때문에 객체 타입 안정성을 높이고 형변환의 번거로움이 줄어든다.
		
		타입 안정성을 높인 다는 것은 의도 하지 않은 타입의 객체가 저장되는 것을 막고, 저장된 객체를 꺼내 올때 원래의 타입과 다른
		타입으로 잘못 형변환 되어 발생할 수있는 오류를 줄여 준다는 뜻이다.
		
		예를 들어, ArrayList와 같은 컬렉션 클래스는 다양한 종류의 객체를 담을 수 있긴 하지만 보통 한 종류의 객체를 담는 경우가 더 많다.
		그런데도 꺼낼 때 마다 타입 체크를 하고 형변환을 하는 것은 아무래도 불편할 수 밖에 없다. 게다가 원하지 않는 종류의 객체가 포함되는
		것을 막을 방법이 없다는 것도 문제다. 이러한 문제들을 지네 릭스가 해결해준다.
		
		 	※ 지네릭스의 장점
		 	1. 타입 안정성을 제공한다.
		 	2. 타입체크와 형변환을 생략할 수 있으므로 코드가 간결해진다.
		 	
		 간단히 얘기하면 다룰 객체의 타입을 미리 명시해 줌으로서 번거로운 형변환을 줄여준다.
		 
		 1.2 지네릭 클래스의 선언
		 
		 지네릭 타입은 클래스와 메서드에 선언 할 수있는데, 먼저 클래스에 선언하는 지네릭 타입에 대해서 알아보자. 예를 들어 클래스
		 Box가 다음과 같이 정의 되어 있다고 가정하자.
		 
		
		  class Box{ Object item;
		  
		  void setItem(Object item) { this.item = item; } Object getItem() { return
		  item; } }
		 
		
		이 클래스를 지네릭 클래스로 변경하면 다음과 같이 클래스 옆에 "<T>"를 붙이면 된다. 그리고 Object를 모두 'T'로 바꾼다.
		
		class Box<T> {
			T item;
			
			void setItem(T item) { this.item = item; }
			T getItem() { return item;}
		}
		
	  Box<T>에서 T를 "타입 변수" 라ㅑ고 하며, "Type"의 첫 글자에서 따온것이다. 타입 변수는 T가 아닌 다른 것을 사용해도 된다.
		ArrayList<E>의 경우 , 타입 변수 E는 "Element(요소)"의 첫 글자를 따서 사용했다.
		
		타입 변수가 여러 개인 경우에는 Map<K, V>와 같이 콤마 ','를 구분자로 나열하면 된다. K는 Key(키)를 의미하며, V는 Value(값)
		을 의미한다. 
		이들은 기호의 종류만 다를 뿐 "임의의 참조형 타입"을 의미 한다는 것은 모두 같다.
		기존에는 다양한 종류의 타입을 다루는 메서드의 매개 변수나 리턴 타입으로 Object 타입의 참조 변수를 많이 사용했고, 그로 인해
		형변환이 불가피 했지만, 이젠 Object타입 대신 원하는 타입을 지정하기만 하면 되는 것이다.
		
		이제 지네릭 클래스가 된 Box 클래스의 객체를 생성 할 때는 다음과 같이 참조 변수와 생성자에 타입 T대신에 사용될 실제 타입을 지정해주어야
		한다.
		
			Box<String> b = new Box<String>();  // 타입 T 대신, 실제 타입을 지정
			//b.setItem(new Object); 			    // 에러 , String 이외의 타입은 지정불가
			b.setItem("ABC");					// 에러가 발생 하지않는ek. 
			String item = b.getItem();
			System.out.println(item);
			
		지네릭스의 용어
		
		지네릭스에서 사용되는 용어들은 자칫 헷갈리기 쉽다. 진도를 더나 가기 전에, 지네릭스의 용어를 먼저 정리하고 넘어가자.
		다음과 같이 지네렉 클래스 Box가 선언 되어 있을때,
				 (원시타입)
			class Box<T> {}
			     지네릭스 클래스
			     
		Box<T> 지네릭 클래스, 'T의 Box' 또는 'T Box' 라고 읽는다.
		T      타입 변수 또는 타입 매개 변수
		Box    원시 타입(raw type)
		
		타입 문자 T는 지네릭 클래스 Box<T> 의 타입 변수 또는 타입 매개 변수라고 하는데, 메서드의
		매개 변수와 우사한 면이 있기 때문이다. 그래서 아래와 같이 타입 매개변수에 타입을 지정하는 것을 '지네릭 타입 호출' 이라고 하고,
		지정된 타입 'String'을 '매개 변수화된 타입(parameterized type)'이라고 한다. 매개 변수화된 타입이라는 용어가 좀 길어서, 앞으로
		이용어 대신 '대입된 타입' 이라는 용어를 사용 할 것이다.
		
		EX) Box<String> b = new Box<String> ();
		    ----------          -------------
		    	 ->   지네릭 타입 호출   <-
	
		 예를 들어, Box<String> 과 Box<Integer>는 지네릭 클래스 Box<T> 서로다른 타입을 대입하여 호출한 것일뿐,
		 이둘이 별개의 클래스를 의마하는 것은 아니다. 이는 마치 매개변수의 값이 다른 메서드 호출, 즉 add(3,5) 와 add(2,4)가
		 서로 다른 메서드를 호출 하는 것이 아닌 것과 같다.
		 
		 컴파일 후에 Box<String> 과 Box<Integer>는 이들의 "원시 타입" 인 Box로 바뀐다. 즉 지네릭 타입이 제거된다.
	 
	   ※지네릭스의 제한
		 
		 지네릭 클래스 Box의 객체를 생성할때, 객체별로 다른 타입을 지정하는 것은 적절하다. 지네릭스는 이처럼 인스턴스별로 다르게
		 동작하도록 하려고 만든 기능이니
		 
		 		Box<Apple> appleBox = new Box<Apple>(); // OK, Apple 객체만 저장가능
		 		Box<Grape> grapeBox = new Box<Grape>(); // OK, Grape 객체만 저장가능
		 
		 그러나 모든 객체에 대해 동일하게 동작해야 하는 static멤버 변수에 타입 변수 T를 사용할수 없다. T는 인스턴스 변수로
		 간주되기 때문이다. 이미 알고 있는 것처럼 static 멤버 는 인스턴스 변수를 참조 할 수 없다.
	 
	   class Box<T> {
			 static T item; // 에러
			 static int compare(T t1, T t2) {...} // 에러
		 }
	 
	   static 멤머는 타입 변수에 지정된 타입, 즉 대입된 타입의 종류에 관계없이 동일한 것이어야 하기 때문이다.
	 	 즉, "Box<Apple>,item" 과 "Box<Grape>.item"이 다른 것이어서는 안된다는 뜻이다.
		 그리고 지네릭 타입의 배열을 생성하는 것도 허용되지 않는다. 지네릭 타입의 참조 변수를 선언하는 것은 가능하지만
		  'ew T[10]'과 같이 배열을 생성하는 것은 안된다는 뜻이다.
	 
		  class Box2<T> {
		 	T[] itemArr; // OK, T 타입의 배열을 위한 참조 변수		 
		 	
			
			  T[] toArray() { T[] tmpArr = new T[itemArr.length]; // 에러 }
			 
		  }
	}
	
	
	  	지네릭 배열을 생성할 수 없는 것은 new 연산자 때문인데, 이 연산자는 컴파일 시점에 타입 T가 뭔지 정확히 알아야 된다. 그런데 위의
	  	코드에 정의된 Box[T] 클래스를 컴파일 하는 시점에서는 T가 어떤 타입이 될지 전혀 알 수 없다. instanceof 연산자 도 new
	  	연산자와 같은 이유로 T를 피연산자로 사용 할 수 없다. 꼭 지네릭 배열을 새로 생성해야할 필요가 있을 때는 , new 연산자 대신
	 	"Reflection API"의 newInstance()와 같이 동적으로 객체를 생성하는 메서드로 배열을 생성하거나, Object배열을
	  	생성해서 복사한 다음에 T[]로 형변환 하는 방법등을 하용한다.
	 
	
	
		1.3 지네릭 클래스의 객체 생성과 사용
	
		지네릭 클래스 , Box<T>가 다음과 같이 정의 되어 있다고 가정하자, 이 Box<T>의 객체에는 한자지 종류, 즉 T타입의 객체만 저장할 수 있다.
		, 전과 달리 ArrayList를 이용해서 여러 객체를 저장 할수 있도록 하였다.
	
	
		class Box<T> {
			ArrayList<T> list = new ArrayList<T>();
			
			void add(T item) 	   	   {list.add(item);     }
			T get (int i) 	 	   	   { return list.get(i); }
			ArrayList<T> getList() 	   { return list;		 }
			int size()			   	   {return list.size();  }
			public String toString ()  {return list.toString();}
		}
		
	
	   Box<T> 의 객체를 생성할 때는 다음과 같이 한다. 참조 변수와 생성자에 대입된 타입(매개 변수화된 타입)이 일치해야한다. 일치 하지
	   않으면 에러가 발생한다.
	
		
		Box<Apple> appleBox = new Box<Apple>(); // OK
		Box<Apple> appleBox = new Box<Grap> (); // 에러
	
		두타입이 상속 관계에 있어도 마찬가지이다. Apple이 Fruit의 자손이라고 가정하자.
		
		Box<Fruit> appleBox = new Box<apple>();
		
		단, 두 지네릭 클래스의 타입이 상속 관계에 있고, 대입된 타입이 같은 것은 괜찮다.
		FruitBox는 Box의 자손이라고 가정하자.
		
		Box<Apple> appleBox = new FruitBox<Apple>(); // OK. 다형성
		
		JDK1.7 부터는 추정이 가능한 경우 타입을 생략할 수 있게 되었다. 참조 변수의 타입으로 부터 Box가 
		Apple이라는 타입의 객체만 저장한다는 것을 알 수 있기 때문에, 생성자에 반복해서 타입을 지정해주지 않아도 되는 것이다.
		따라서 아래의 두문장은 동일하다
		
		Box<Apple> appleBox = new Box<Apple> ();
		Box<Apple> appleBox = new Box<>(); // Ok. JDK 1.7부터 생략가능
		
		생성된 Box<T>의 객체에 'void add(T item' 으로 객체를 추가 할때, 대입된 타입과 다른 타입의 객체는 추가할 수 없다.
		
		Box<Apple> appleBox = new Box<Apple>();
		appleBox.add(new Apple()); // OK.
		appleBox.add(new Grape()); // 에러. BNox<apple>에는 Apple객체만 추가 가능
		
		그러나 타입 T,가 'Fruit' 인 경우 , 'void add(Fruit item)'가 되므로 Fruit의 자손들은 이메소드의
		매개 변수가 될 수 있다. Apple이 Fruit의 자손이라고 가정하였다.
		
		Box<Fruit> fruitBox = new Box<Fruit>();
		fruitBox.add(new Fruit()); // OK
		fruitBox.add(new Apple()); // Ok, void add(Fruit item
	*/
	
		Box<Fruit> fruitBox = new Box<Fruit>();
		Box<Apple> appleBox = new Box<Apple>();
		Box<Toy>   toyBox   = new Box<Toy>();
//      Box<Grape> grapeBox = new Box<Apple>(); // 에러. 타입 불일치
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple()); // OK, void add(Fruit item)
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
	  //appleBox.add(new Toy()); // ,에러 appleBox에는 apple만 담을 수있음
		
	  toyBox.add(new Toy());
	  //toyBox.add(new Apple()); // 에러. Box<Toy>에는 Apple을 담을 수 없음
		
		System.out.println(fruitBox);
		System.out.println(appleBox);
		System.out.println(toyBox);
	}
}

class Box<T> {
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) { list.add(item); 	   }
	T get(int i)     { return list.get(i); }
	int size()       { return list.size(); }
	public String toString() { return list.toString();}
}
