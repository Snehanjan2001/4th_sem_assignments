//import java.util.Iterator

public class q2 {
	public static void main(String[] args) {
		//check if the argument s empty or not
		
		if (args.length==0) {
			System.out.println("No arguments found");
		}
		
		System.out.println(args.length);
		for(int i=0 ;i<args.length;i++) {
			System.out.println(args[i]);
		}
	}

}
