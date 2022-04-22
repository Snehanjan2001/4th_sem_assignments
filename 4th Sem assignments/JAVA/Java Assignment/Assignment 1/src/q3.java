import java.util.Scanner;

public class q3 {
	
	public static void main(String[] args) {
		int hcm,hf,hi;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the heights in cetimeters");
		hcm=sc.nextInt();
		sc.close();
		hf= (int) ((int)hcm/30.5);
		hi=(int) ((hcm%30.5)/2.54);
		
		System.out.println("The height is "+hf+ " feet "+hi+" inches ");
		
		
		
		
		
	}

}
