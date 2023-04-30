package com.project.enums;

enum DirectionEx {
	EAST(1, ">"), SOUTH(2,"V"), WEST(3,"<"), NORTH(4,"^");
	
	private static final DirectionEx[] DIR_ARR = DirectionEx.values();
	private final int value;
	private final String symbol;
	
	DirectionEx(int value, String symbol) {
		this.value = value;
		this.symbol = symbol;
	}
	
	public int getValue() { return value; }
	public String getSymbol() { return symbol; }
	
	public static DirectionEx of (int dir) {
		if (dir < 1 || dir > 4) {
			throw new IllegalArgumentException("Invalid value :" + dir);
		}
		
		return DIR_ARR[dir -1];
	}
	
	// 방향을 회전시키는 메소드. num 의 값만큼 90도씩 시계방향으로 회전한다.
	public DirectionEx rotate (int num) {
		num = num % 4;
		
		if(num < 0) num += 4; // num이 음수일 때는 시계반대 방향 으로 회전
		return DIR_ARR[(value-1+num) % 4];
	}
	
	public String toString() {
		return name() + getSymbol();
	}
}

public class EnumEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	/*	2.3 열거형에 멤버 추가하기
		
		Enum 클래스에 정의된 ordinal()이 열거형 상수가 정의 된 순서를 반환 하지만, 이값을 열거형 상수의 값으로
		사용하지 않는 것이 좋다. 이값은 내부적인 용도로만 사용되기 위한 것이기 때문이다.
		열거형 상수의 값이 불연속적인 경우에는 이때는 다음과 같이 열거형 상수의 이름옆에 원하는 값을 괄호() 와 함께 적어주면 된다.
		
		enum Direction { EAST(1), SOUTH(5), WEST(-1), NORTH(10) }
		
		그리고 지정된 값을 저장 할 수있는 인스턴스 변수와 생성자를 새로 추가해 주어야 한다.
		이 때 주의할 점은, 먼저 열거형 상수를 모두 정의한 다음에 다른 멤버들을 추가해야 한다는 것이다. 그리고 열거형 상수의 마지막에
		; 도 잊지 말아야 한다.
		
			enum Direction {
				EAST(1), SOUTH(5), WEST(-1), NORTH(10); // 끝에 ';' 를 추가해야 한다.
				
				private final int value;
				Direction (int value) { this.value = value; }
				public int getValue() { return value; }
			}
		
		열거형의 인스턴스 변수는 반드시 final 이어야 한다는 제약은 없지만, value는 열거형 상수의 값을 저장 하기 위한것이므로 
		,final을 붙였다.
		그리고 외부에서 이 값을 얻을 수 있게 getValue()도 추가하였다.
		
		Direction d = new Direction(1); // 에러 열거형의 생성자는 외부에서 호출불가
		
		열거형 Direction에 새로운 생성자가 추가되었지만, 위와 같이 열거형의 객체를 생성할 수없다. 열거형의 생성자는 제어자가
		묵시적으로 private이기 때문이다.
		
			enum Direction {
				
				Direction(int value)
			}
		
		필요하다면, 다음과 같이 하나의 열거형 상수에 여러 값을 지정 할 수도 있다. 다만 그에 맞게 인스턴스 변수와 생성자
		등을 새로 추가해주어야 한다.
		
		enum Direction {
			EAST(1, ">"), SOUTH(2,"V"), WEST(3,"<"), NORTH(4,"^");
		
		
		private final int value;
		private final String symbol;
		
		Direction(int value, String symbol) { // 접근 제어자 private가 생략됨
			this.value = value;
			this.symbol = symbol;
		}
		
		public int getValue() { return value; }
		public String getSymbol() { return symbol;}
			
		}
	*/
		for( DirectionEx d : DirectionEx.values()) 
			System.out.printf("%s=%s%n", d.name(), d.getSymbol());
		
			DirectionEx d1 = DirectionEx.EAST;
			DirectionEx d2 = DirectionEx.of(1);
			
		System.out.printf("d1=%s, %d%n",d1.name(),d1.getValue());
		System.out.printf("d2=%s, %d%n",d2.name(),d2.getValue());
		
		System.out.println(DirectionEx.EAST.rotate(1));
		System.out.println(DirectionEx.EAST.rotate(2));
		System.out.println(DirectionEx.EAST.rotate(-1));
		System.out.println(DirectionEx.EAST.rotate(-4));
		
	}
}