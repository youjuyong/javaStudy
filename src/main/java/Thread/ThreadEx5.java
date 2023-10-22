package Thread;

public class ThreadEx5 {
	static long startTime = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadEx5_1 th1 = new ThreadEx5_1();
		th1.start();
	    startTime = System.currentTimeMillis(); 
	    
	    for(int i = 0; i < 300; i++) {
	    	System.out.printf("%s", new String("-"));
	    }
	    
	    System.out.println("소요시간1:" + (System.currentTimeMillis()-ThreadEx5.startTime));
	}
	
}


class ThreadEx5_1 extends Thread {
	public void run() {
		for( int i =0 ; i < 300; i++) {
			System.out.printf("%s", new String("|"));
		}
		System.out.println("소요시간시간2:" + (System.currentTimeMillis() - ThreadEx5.startTime));
	}
}