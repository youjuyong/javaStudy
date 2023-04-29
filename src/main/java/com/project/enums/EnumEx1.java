package com.project.enums;

enum Direction { EAST, SOUTH, WEST, NORTH }

public class EnumEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	
		2. 열거형(enums)
		
		2.1 열거형 이란?
				
		열거형은 서로 관련된 상수를 편리하게 선언 하기 위한 것으로 여러 상수를 정의 할때 사용하면 유용하다.
		원래 자바는 C언어와 달리 열거형이라는 것이 존재 하지 않았으나 ,JDK 1.5부터 새로 추가 되었다.
		
		자바의 열거형은 C언어의 열거형보다 더 향상된 것으로 열거형이 갖는 값뿐만 아니라 타입도 관리하기 때문에 보다
		논리적인 오류를 줄일 수 있다.
		
		EX) class Card {
			static final int CLOVER = 0;
			static final int HEAT = 1;
			static final int DTAMOND = 2;
			static final int SPADE = 3;
			
			static final int TWO = 0;
			static final int THERE = 1 ;
			static final int FOUR = 2;
			
			final int kind;
			final int num;
		}
		
		위의 예제를
		
		class Card{
			enum Kind { CLOVER, HEAT, DIMOND, SPADE } // 열거형 Kind 정의
			enum Value { TWO, THREE, FOUR }
			
			final Kind kind; // 타입이 int가 아닌 Kind임에 유의
			final Value value;
		}
		
		기존의 많은 언어들 , 예를 들어 C언어에서는 타입이 달라고 값이 같으면 조건식 결과가 참(true) 이었는데
		자바의 열거형은 "타입에 안전한 열거형" 이라서 실제 값이 같아도 타입이 다르면 컴파일 에러가 발생한다. 이처럼 값뿐만 아니라
		타입 까지 체크 하기 때문에 안전하다고 하는 것이다.
		
			if(Card.CLOVER == Card.TWO) // true 이지만, false여야 의미상 맞다.
			if(Card.Kind.CLOVER == Card.Value.TWO) // 컴파일 에러. 값은 같지만 타입이 다름
				
		그리고 더 중요한 것은 상수의 값이 바뀌면, 해당 상수를 참조하는 모든 소스를 다시 컴파일 해야한다는 점이다. 하지만 열거형
		상수를 사용하면, 기존의 소스를 다시 컴파일 하지 않아도 된다.
		
		2.2 열거형의 정의와 사용
		
		열거형을 정의하는 방법은 간단한다. 다음과 같이 괄호 [] 안에 상수의 이름을 나열하기만 하면 된다.
		
		enum 열거형 이름 { 상수형1, 상수형2, .값뿐만..}
		
		예를 들어 동서남북 4방향을 상수로 정의하는 열거형 Direction 은 다음과 같다.
			enum Direction { EAST, SOUTH, WEST, NORTH }
		
		이 열거형에 정의된 상수를 사용하는 방법은 "열거형 이름. 상수명이다." 클래스의 static 볁수를 참조 하는 것과 동일하다.
		
			class Unit {
				int x, y; 		// 유닛의 위치
				
				Direction dir;	// 열거형을 인스턴스 변수로 선언
				
				void init() {
					dir = Direction.EAST;
				}
			}
		
		열거형 상수간의 비교에는 "==" 를 사용 할 수 있다. equals() 가 아닌 "==" 로 비교가 가능하다는것은
		그만큼 빠른 성늘을 제공 한다는 얘기다. 그러나 "<','>" 와 같은 비교연산자는 사용 할 수 없고 compareTo()는
		사용가능하다. 앞서 배운 것과 같이 compareTo()는 두 비교대상이 같으면 () , 왼쪽이 크면 양수, 오른쪽이 크면 음수를 반환한다.
		
		if(dir == Direction.EAST) {
			x++;
		} else if (dir > Direction.WEST) { // 에러, 열거형 상수에 비교 연산자 사용불가
			---
		} else if( dir.compareTo(Direction.WEST) > 0) { // compareTo() 는 가능
			---
		}
		
		다음 과 같이 switch 문의 조건식에도 열거형을 사용 할 수도 있다.
		
		void move() {
			switch(dir) {
				case EAST : x++;
					break;
				case WEST : x--;
					break;
				case SOUTH : y++;
					break;
				case NORTH : y--;
					break;
			}
 		}
		
		// 이 때 주의할 점은 Case 문에 열 거형의 이름은 적지 않고 상수의 이름만 적어야 한다는 제약이 있다. 아마도 
		그렇게 하는 것이 오타도 줄일수 있고 보기에도 간결하기 때문이다.
		
		모든 열거형의 조상 - java.lang.Enum
		열거형 Direction 에 정의된 모든 상수를 출력하려면, 다음과 같이 한다.
		
		Direction[] dArr = Direction.values();
		
		for(Direction d : dArr) 
			System.out.println("%s = %d%n", d.name(), d.oridinal());
		
		values()는 열거형의 모든 상수를 배열에 담아 반환한다. 이메서드는 모든 열거형이 가지고 있는 것으로 
		컴파일러가 자동으로 추가해 준다. 그리고 ordinal()은 모든 열거형의 조상인 java.lang.Enum 클래스에 정의된 것으로
		열거형 상수가 정의된 순서를 정수로 반환한다.
		
		그밖에도
		Closs<E> getDeclaringClass()   : 열거형 Class 객체를 반환한다.
		String name()                  : 열거형 상수의 이름을 문자열로 반환한다.
		int ordinal()                  : 열거형 상수가 정의된 순서를 반환한다.
		T valueOf(Class<T> enumType, String name) : 지정된 열거형에서 name과 일치하는 열거형 상수를 반환한다.
		
		이외에도 values() 처럼 컴파일러가 자동적으로 추가해주는 메서드가 하나 더있다
		
		static E values()
		static E valueOf(String name)
		
		이 메서드는 열거형 상수의 이름으로 문자열 상수에 대한 참조를 얻을수 있게 해준다.
		Direction d = Direction.valueOf("WEST");
		System.out.println(d); // WEST
		System.out.println(Direction.WEST == Direction.valueOf("WEST")); // true
		
	*/
		Direction d1 = Direction.EAST;
		Direction d2 = Direction.valueOf("WEST");
		Direction d3 = Enum.valueOf(Direction.class, "EAST");
		
		System.out.println("d1="+d1);
		System.out.println("d2="+d2);
		System.out.println("d3="+d3);
		
		System.out.println("d1==d2 ? "+ (d1==d2));
		System.out.println("d1==d3 ? "+ (d1==d3));
		System.out.println("d1.equals(d3) ? " + d1.equals(d3));
	//	System.out.println("d2 > d3 ? " + (d1 > d3));
		System.out.println("d1.compareTo(d3) ? " + (d1.compareTo(d3)));
		System.out.println("d1.compareTo(d2) ? " + (d1.compareTo(d2)));
		
		switch(d1) {
			case EAST:
				System.out.println("The direction is EAST.");
				break;
			case SOUTH:
				System.out.println("The direction is SOUTH.");
				break;
			case WEST:
				System.out.println("The direction is WEST.");
				break;
			case NORTH:
				System.out.println("The direction is NORTH.");
				break;
		}
			
		Direction[] dArr = Direction.values();
		
		for(Direction d : dArr) 
			System.out.printf("%s = %d%n",d.name(),d.ordinal());
	}
}
