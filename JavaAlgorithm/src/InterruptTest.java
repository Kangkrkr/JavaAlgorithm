import java.io.ObjectInputStream.GetField;


class MyThread extends Thread {

	public MyThread(String name){
		super(name);
	}
	
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()){
			try {
				Thread.sleep(500);
				System.out.println(getName()+" 스레드 살아있음 ..");
			} catch (InterruptedException e) {}
		}
		
		System.out.println(getName()+" 스레드 쥬금..");
	}
	
}

public class InterruptTest {

	public static void main(String[] args) {

		MyThread myThread = new MyThread("my thread");
		myThread.start();
		
		for(int i=0; i<10; i++){
			try {
				if(i >= 9){
					myThread.interrupt();
				}
				System.out.println(Thread.currentThread().getName()+" 스레드 동작중..");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
