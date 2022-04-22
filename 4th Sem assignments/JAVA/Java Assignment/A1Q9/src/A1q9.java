
class BankAcc{
    int accno;
    double balance;
    int interest=10;
    BankAcc(int a,double b){
        accno = a;
        balance = b;
    }
    void change(int i){
        interest = i;
    }
    void display(){
        System.out.println("ACCOUNT NO : " + accno);
        System.out.println("BALANCE : " + balance);
        System.out.println("INTEREST : " + interest);
    }
    double finalBal(int y){
       balance = balance + (balance*y*interest)/100;
       return balance;
    }


}
class A1q9{
    public static void main(String args[]){
        BankAcc b1 = new BankAcc(1,1000);
        BankAcc b2 = new BankAcc(2,2000);
        b1.display();
        b2.display();
        b1.change(20);
        b1.display();
        b2.display();
        b1.finalBal(10);
        b1.display();
        b2.display();
    }
}
