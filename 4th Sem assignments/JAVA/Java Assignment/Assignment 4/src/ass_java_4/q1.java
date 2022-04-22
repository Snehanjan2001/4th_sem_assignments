package ass_java_4;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;


class IncrementRunnable implements Runnable{
	ThreadData data;
	int valueToIncrement;
	
	public IncrementRunnable(ThreadData data, int valToIncrement) {
		this.data = data;
		this.valueToIncrement = valToIncrement;
	}
	
	@Override
	public void run() {
		this.data.increment(valueToIncrement);
	}
	
}


class DecrementRunnable implements Runnable{
	int fixedamount=100;
	ThreadData data;
	
	public DecrementRunnable(ThreadData data) {
		this.data = data;
	}
	
	@Override
	public void run() {
		this.data.decrement(fixedamount);
	}
	
}


public class q1 {
	public static void main(String[] args) throws InterruptedException {
		ThreadData data = new ThreadData(0);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the value to increment : ");
		int valueToIncrement = sc.nextInt();
		
		
		Thread t1 = new Thread(new DecrementRunnable(data));
		Thread t2 = new Thread(new IncrementRunnable(data, valueToIncrement));
		Thread t3 = new Thread(new DecrementRunnable(data));
		
        
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


