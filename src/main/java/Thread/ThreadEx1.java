package Thread;

import Thread.ThreadEx1_1;
import Thread.ThreadEx1_2;

public class ThreadEx1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadEx1_1 t1 = new ThreadEx1_1();
		
		Runnable r = new ThreadEx1_2();
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
	}

}

class ThreadEx1_1 extends Thread {
	public void run() {
		for(int i =0; i < 5; i++) {
			System.out.println(getName());
		}
	}
}

class ThreadEx1_2 implements Runnable {
	public void run() {
		for(int i = 0; i < 5; i++) {
			// Thread.currentThread() 현재 실행중인 Thread 반환
			System.out.println(Thread.currentThread());
		}
	}
}

