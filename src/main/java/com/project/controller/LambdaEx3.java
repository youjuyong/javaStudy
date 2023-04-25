package com.project.controller;

@FunctionalInterface
interface MyFunction3 {
	void myMethod();
}
class Outer{
	int val = 10; // Outer.this.val
	
	class Inner {
		int val= 20; // this.val
		
		void method(int i) { // void method(final int i)
			int val = 30; // final int val = 30;
	//		i = 10;	 	// 에러 상수값을 변경 할 수 없음
			
			MyFunction3 f = () -> {
				System.out.println("             i : " + i);
				System.out.println("           val : " + val);
				System.out.println("      this.val : " + ++this.val);
				System.out.println("Outer.this.val : " + ++Outer.this.val);
			};
			f.myMethod();
		}
	}
}

public class LambdaEx3 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 람다식도 익명 객체. 즉 익명 클래스의 인스턴스 이므로 람다식에서 외부에 선언된 변수에 접근하는 규칙은 앞서 익명 클래스에서 배운것과
		 * 동일하다.
		 */
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.method(100);
		
		/*
		 * 이 예제는 람다식 내에서 외부에 선언된 변수에 접근하는 방법을 보여준다. 람다식 내에서 참조하는 지역변수는 final이 붙지 않았어도
		 * 상수로 간주한다. 람다식 내에서 지역 변수 i와 val 을 참조 하고 있으므로 람다식 내에서나 다른 어느 곳에서도 이 변수들의 값을
		 * 변경하는 일은 허용 되지 않는다. 반면에 Inner 클래스와 Outer 클래스의 인스턴스 변수인 this.val 과
		 * Outer.this.val 은 상수로 간주 되지 않으므로 값을 변경 해도 된다.
		 */
		
		//출력 결과
		//	           i : 100
        //           val : 30
        //	  t  his.val : 21
      	//Outer.this.val : 11

	}

}
