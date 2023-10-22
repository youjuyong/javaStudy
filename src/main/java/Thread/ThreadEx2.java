package Thread;

public class ThreadEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadEx2_1 t1 = new ThreadEx2_1();
		t1.start();
	}
	
}

class ThreadEx2_1 extends Thread {
	public void run() {
		throwException();
	}
	
	public void throwException() {
		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
