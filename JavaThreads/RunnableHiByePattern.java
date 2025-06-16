package finalquestions;

public class RunnableTreadQ {
	static Object lock = new Object(); //this should be static
	public static void main(String[] args) {
		Thread hi = new Thread(new PrintHi());
		Thread bye = new Thread(new PrintBye());
		
		hi.start();
		bye.start();
	}

static class PrintHi implements Runnable{ //R capital
		public void run() {
			synchronized(lock) {
				for(int i=0; i<5; i++) {
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
static class PrintBye implements Runnable{
		public void run() {
			synchronized(lock) {
				for(int i=0; i<5; i++) {
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
}
