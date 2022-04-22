import java.util.Scanner;

class Metric{
    void KtoM(double k){
        double m = k/1.5;
        System.out.println(m);
    }
    void MtoK(double m){
        double k = m*1.5;
        System.out.println(k);
    }
}
class A1q10{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER IN KILOMETERS ");
        double k = sc.nextDouble();
        System.out.println("ENTER IN MILES ");
        double mi = sc.nextDouble();
        Metric m = new Metric();
        m.KtoM(k);
        m.MtoK(mi);
        sc.close();
    }
}