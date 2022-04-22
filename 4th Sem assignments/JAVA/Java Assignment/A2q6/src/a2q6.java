import java.util.Scanner;

public class a2q6 {
    @SuppressWarnings("unused")
	public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any integer : ");
        int x = sc.nextInt();
        sc.nextLine();
        
        Integer x1 = Integer.valueOf(x);  // basic type to object
        System.out.println("Basic type to object : "+x1);
        
        int x2 = x1.intValue(); // object to basic type
        System.out.println("Object to basic type : "+x2);
        
        String s1= Integer.toString(x); // basic type to string
        
        System.out.print("Enter any string : ");
        String s = sc.nextLine();

        try{
        	Integer x3 = Integer.valueOf(s); // String to basic type
        	System.out.println("String to basic type : "+x3);
        }
        catch(NumberFormatException e){
            System.out.println("Failed on converting string to integer");
        }
        
        try{
            String s2 = x1.toString(); // numeric object to string
            System.out.println("Numeric object to string : "+s2);
        }
        catch(NumberFormatException e){
            System.out.println("Failed on converting integer to string");
        }
        sc.close();
    }
}
