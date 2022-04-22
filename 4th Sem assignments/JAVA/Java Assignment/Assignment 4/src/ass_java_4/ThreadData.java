package ass_java_4;

public class ThreadData {
	int val;
	public ThreadData(){
		val = 0;
	}
	public ThreadData(int val){
		this.val = val;
	}
	public void increment(int value) {
		this.val += value;
	}
	public void decrement(int value) {
		this.val -= value;
	}
	public int getValue() {
		return val;
	}
}
