
class instructor{
    int ph;
    String name;
    instructor(int p, String n){
        ph = p;
        name = n;
    }
    void display(){
        System.out.println("INSTRUCTOR PHONE NUMBER : " + ph);
        System.out.println("INSTRUCTOR NAME : " + name);
    }
    void setph(int p ){
        ph = p;
    }
    void setName(String n){
        name = n;
    }
}
class TextBook{
    String title;
    String author;
    String publisher;
    TextBook(String t, String a, String p){
        title = t;
        author = a;
        publisher = p;
    }
    void display(){
        System.out.println("BOOK TITLE : " + title);
        System.out.println("BOOK AUTHOR : " + author);
        System.out.println("BOOK PUBLISHER : " + publisher);
    }
    void setTitle(String t){
        title = t;
    }
    void setAuthor(String a){
        author = a;
    }
    void setPublisher(String p){
        publisher = p;
    }
}
class course{
    String courseName = " ";
    instructor i1 = new instructor(0," ");
    TextBook t1 = new TextBook(" "," "," ");
    void display(){
        System.out.println("COURSE NAME : " + courseName);
        i1.display();
        t1.display();
    }
    void setCourseName(String c){
        courseName = c;
    }
    void setInstructor(int p, String n){
        i1.setph(p);
        i1.setName(n);
    }
    void setTextBook(String t, String a, String p){
        t1.setTitle(t);
        t1.setAuthor(a);
        t1.setPublisher(p);
    }




}
class A1q11{
    public static void main(String args[]){
        course c1 = new course();
        c1.setCourseName("JAVA");
        c1.setInstructor(123456789,"ABC");
        c1.setTextBook("JAVA","ABC","XYZ");
        c1.display();
    }
}

