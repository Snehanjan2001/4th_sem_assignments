import java.util.*;


public class StringPRoblem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
        String str2 = str1;
        if (str1 == str2)
            System.out.println("str1 and str2 are equal via == operator");
        else
            System.out.println("str1 and str2 are not equal via == operator");
        if (str1.equals(str2))
            System.out.println("str1 and str2 are equal via .equals() function");
        else
            System.out.println("str1 and str2 are not equal via .equals() function");
        System.out.println("\n");
        String str3 = "abcdefg";
        String str4 = "abcdefg";
        if (str3 == str4)
            System.out.println("str3 and str4 are equal via == operator");
        else
            System.out.println("str3 and str4 are not equal via == operator");
        if (str3.equals(str4))
            System.out.println("str3 and str4 are equal via .equals() function");
        else
            System.out.println("str3 and str4 are not equal via .equals() function");
		
		
	}

}
