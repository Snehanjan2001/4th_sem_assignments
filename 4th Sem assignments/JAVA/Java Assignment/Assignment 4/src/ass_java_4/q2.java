package ass_java_4;

import java.util.Scanner;



class IncrementRunnable2 implements Runnable{
	ThreadData data;
	int valueToIncrement;
	
	public IncrementRunnable2(ThreadData data, int valToIncrement) {
		this.data = data;
		this.valueToIncrement = valToIncrement;
	}
	
	@Override
	public void run() {
		synchronized (data) {
			this.data.increment(valueToIncrement);
		}
		System.out.println("In : "+data.val);
	}
	
}


class DecrementRunnable2 implements Runnable{
	int fixedamount=100;
	ThreadData data;
	
	public DecrementRunnable2(ThreadData data)  {
		this.data = data;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized(data) {
			this.data.decrement(fixedamount);
		}
	}
	
}


public class q2 {
	public static void main(String[] args) throws InterruptedException {
		ThreadData data = new ThreadData(0);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the value to increment : ");
		int valueToIncrement = sc.nextInt();
		
		
		Thread t1 = new Thread(new DecrementRunnable2(data));
		Thread t2 = new Thread(new IncrementRunnable2(data, valueToIncrement));
		Thread t3 = new Thread(new DecrementRunnable2(data));
		
        
		System.out.println("Current value before starting threads : "+data.getValue());

		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
		
		System.out.println("Current value after running all threads : "+data.getValue());
		
	}
	

}

