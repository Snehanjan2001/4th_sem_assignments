import java.util.*;
class as2q3
{
public static void main(String[] args)
    {
        String s = "I am Snehanjan and I am enough";
        int n = s.length();
        int ctr_for_a = 0;
        int ctr_for_and =0;
        boolean b = false;
        if(s.charAt(0)=='T' && s.charAt(1)=='h' && s.charAt(2)=='e'){
            b = true;
        }
        System.out.println(b );
        for(int i=0; i<n; ++i){
            if(s.charAt(i) == 'a'){
                ctr_for_a++;
                if(i<n-2 && s.charAt(i+1)== 'n' && s.charAt(i+2)== 'd'){
                    ctr_for_and++;
                }
            }
        }
        System.out.println(ctr_for_a );
        System.out.println(ctr_for_and );
        char[] c = new char[n];
        for(int i=0; i<n; ++i){
            c[i] = s.charAt(i);
        }
        System.out.println(c[0] );
        StringTokenizer st1 = new StringTokenizer(s , " @.");
        System.out.println(st1.countTokens());



    
    }
}