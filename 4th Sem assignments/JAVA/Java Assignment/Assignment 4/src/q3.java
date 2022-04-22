import java.util.Scanner;

class SData{
	int x;
	
	public SData(int x) {
		this.x = x;
	}
	
	public void setVal(int x) {
		this.x = x;
	}
	
	public int getVal() {
		return x;
	}
}

class Permission{
	private int count_read = 0;
	private int count_write = 0;
	private int count_write_requests = 0;
	
	synchronized public void seekReadPermission() {
		if(count_write > 0 || count_write_requests >0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count_read++;
		}
	}
	
	
	synchronized public void seekWritePermission() {
		count_write_requests++;
		if(count_write > 0 || count_read > 0) {
			try {
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		count_write_requests--;
		count_write++;
	}
	
	synchronized public void readOverNotification() {
		count_read--;
		notifyAll();
	}
	
	synchronized public void writeOverNotification() {
		count_write--;
		notifyAll();
	}
}

class Reader implements Runnable{
	SData data;
	Permission permission;
	
	public Reader(SData data, Permission permission) {
		this.data = data;
		this.permission = permission;
	}

	@Override
	public void run() {
//		permission.seekReadPermission();
		System.out.println("Read value : "+data.getVal());
//		permission.readOverNotification();
	}
	
}

class Writer implements Runnable{
	SData data;
	Permission permission;
	int newVal;
	
	public Writer(SData data, Permission permission, int newVal) {
		this.data = data;
		this.permission = permission;
		this.newVal = newVal;
	}

	@Override
	public void run() {
		permission.seekWritePermission();
		data.setVal(newVal);
		permission.writeOverNotification();
	}
	
}


public class q3 {
	public static void main(String[] args) throws Exception {
		SData data = new SData(34);
		Permission permission = new Permission();
		
		
		Thread reader1 = new Thread(new Reader(data, permission));
		Thread reader2 = new Thread(new Reader(data, permission));
		
		Thread writer1 = new Thread(new Writer(data, permission, 50));
		Thread writer2 = new Thread(new Writer(data, permission, 60));
		
		reader1.start();
		writer1.start();
		writer2.start();
		reader2.start();
		
		reader1.join();
		writer1.join();
		writer2.join();
		reader2.join();
		
		System.out.println(data.getVal());
		
	}
}
