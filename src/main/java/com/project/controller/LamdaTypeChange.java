package com.project.controller;

@FunctionalInterface
interface MyFunction2 {
	void myMethod();
}
public class LamdaTypeChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * // 람다식의 타입과 형변환 함수형 인터 페이스로 람다식을 참조 할수 있는 것일뿐 람다식의 타입이 함수형 인터 페이스 타입과 일치 하는
		 * 것은 아니라. 람다식은 익명 객체 이고 익명 객체는 타입이 없다. 정확히는 타입이 있지만 컴파일러가 임의로 이름을 정하기 때문에 아래와
		 * 같이 형변환이 필요하다.
		 */
		
		// MyFunction f = (MyFunction) (() -> {}); // 양변의 타입이 다르므로 형변환이 필요
		
		/*
		 * 람다식은 MyFunction 인터페이스를 직업 구현 하지 않았지만, 이인터페이스를 구현한 클래스의 객체와 완전히 동일하기 때문에 위와같은
		 * 형변환을 허용한다. 그리고 이 형변환은 생략가능하다. 람다식은 이름이 없을 뿐 분명히 객체 인데도, 아래와 같이 Object 타입으로
		 * 형변환 할 수 없다. 람다식은 오직 함수형 인터페이스로만 형변환이 가능하다.
		 */
		// Object obj = (Object)(() -> {}); // 에러 , 함수형 인터페이스로만 형변환 가능
		
		MyFunction f = () -> {}; // MyFunction f = (MyFunction) (() -> {});
		Object obj = (MyFunction2) (() -> {}); // Object 타입으로 형변환이 생략됨
		String str = ((Object)(MyFunction2)(() ->{})).toString();
		
		System.out.println(f);
		System.out.println(obj);
		System.out.println(str);
	  //System.out.println(()->{}); 에러 람다식은 Object 타입으로 형변환 되지않는다.
		System.out.println((MyFunction2)(() -> {}));
      //System.out.println((MyFunction2)(() -> {}).toString()); 에러 
		System.out.println(((Object)(MyFunction2)(() -> {})).toString());
		
		/*
		 * 출력 결과
		 * com.project.controller.LamdaTypeChange$$Lambda$1/0x0000000100060840@4141d797
		 * com.project.controller.LamdaTypeChange$$Lambda$2/0x0000000100061040@68f7aae2
		 * com.project.controller.LamdaTypeChange$$Lambda$3/0x0000000100061440@47089e5f
		 * com.project.controller.LamdaTypeChange$$Lambda$4/0x0000000100061840@4c3e4790
		 * com.project.controller.LamdaTypeChange$$Lambda$5/0x0000000100061c40@5679c6c6
		 */

		
	}

}
