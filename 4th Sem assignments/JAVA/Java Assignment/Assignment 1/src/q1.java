import java.util.*;

public class q1 {
	public static void main(String[] args) {
		short num1, num2, sum;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the first number");
		num1 = sc.nextShort();
		System.out.println("Enter the second number");
		num2 = sc.nextShort();

		sc.close();
		sum = (short) (num1 + num2);

		System.out.println(sum);

	}

}
