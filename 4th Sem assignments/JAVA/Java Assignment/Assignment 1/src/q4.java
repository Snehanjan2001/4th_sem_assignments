import java.util.Scanner;

public class q4 {
	public static void main(String[] args) {
		int r;
		double a;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the radius");
		r=sc.nextInt();
		
		sc.close();
		a=(3.14*(r^2));
		
		System.out.println(a);
	}

}
