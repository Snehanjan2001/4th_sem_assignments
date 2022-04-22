import java.util.*;

class A{
	void show(int a) {
		System.out.println(a);
	}
}

class B {
	void show(int a) {
		System.out.println(a);
	}
	
	void show(double b) {
		System.out.println(b);
	}
}
public class A1Q6 {
	 public static void main(String[] args) {
		A l = new A();
		B n = new B();
		
		l.show((short)10);
		// a.show((double)10.5);This gives error
        n.show((short)10);
        n.show((double)10.5);
	}
	 
	 

}
