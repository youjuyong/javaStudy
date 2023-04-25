package com.project.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@FunctionalInterface
interface MyFunction {
	void run(); // public abstract void run();
}

public class JavaRamda {
	static void execute (MyFunction f) {
		f.run();
	}
	
	static MyFunction getMyFunction() {
		MyFunction f = () -> System.out.println("f3.run()");
		return f;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 람다식 이란? 메서드를 하나의 '식(expression)' 으로 표현한 것이다.
		// 람다식은 함수를 간략하면서도 명확한 식으로 표현 할 수있게 도와준다.
		// 메서드를 람다식으로 표현하면 메서드의 이름과 반환값이 없어 지므로, 람다식을 '익명 함수' 라고도한다.
		
		// 람다식으로 MyFunction의 run() 을 구현
		
		MyFunction f1 = () -> System.out.println("f1.run()");
		
		MyFunction f2 = new MyFunction() { // 익명 클래스로 run()을 구현
			public void run() {
				System.out.println("f2.run()");
			}
		};
		MyFunction f3 = getMyFunction();
		f1.run();
		f2.run();
		f3.run();
		
		execute(f1);
		execute(() -> System.out.println("run()"));
	}
}
