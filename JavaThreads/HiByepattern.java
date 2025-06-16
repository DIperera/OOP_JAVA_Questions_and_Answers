package finalquestions;

public class P1 extends Thread{
	private Object lock;
	private int count;
	public P1(Object lock,  int count) {
		super();
		this.lock = lock;
		this.count = count;
	}
	public void run() {
		synchronized (lock) {
			for(int i=0; i<count; i++) {
				System.out.println("Hi");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lock.notify();
			try {
				lock.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	}
	
}
package finalquestions;

public class P2 extends Thread{
	
		private Object lock;
		private int count;
		public P2(Object lock,  int count) {
			super();
			this.lock = lock;
			this.count = count;
		}
		public void run() {
			synchronized (lock) {
				for(int i=0; i<count; i++) {
					System.out.println("Bye");
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lock.notify();
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		}
		
	}
package finalquestions;

import java.util.Scanner;

public class Patternthread {
public static void main(String[] args) {
	Object lock = new Object();
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter a number: ");
	int number = sc.nextInt();
	
	P1 t1 = new P1(lock,  number);
	P2 t2 = new P2(lock,  number);
	
	t1.start();
	t2.start();
	try {
		t1.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		t2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}

