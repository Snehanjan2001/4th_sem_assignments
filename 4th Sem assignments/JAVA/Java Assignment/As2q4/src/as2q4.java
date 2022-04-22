public class as2q4 {
    public static void main(String[] args) {
        int b = 5;
        String bb = "45";

        Integer zz = Integer.valueOf(bb); // String to numeric object
        System.out.println("String : "+bb+" to numeric object : "+zz);

        Integer z = Integer.valueOf(b); // Basic type to object
        System.out.println("Basic type : "+b+" to Object : "+z);

        int y = z.intValue(); // Object to basic type
        System.out.println("Object : "+z+" to basic type : "+y);

        String x = Integer.toString(b);//basic type to string
        System.out.println("Basic type : "+b+" to String : "+x);

        String w = z.toString(); //Object to string
        System.out.println("Object : "+z+" to string : "+w);
    }
}