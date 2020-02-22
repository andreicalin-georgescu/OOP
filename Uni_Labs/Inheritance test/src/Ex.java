class A{
    public int x;
    public A() { this(1); }
    public A(int x) {
        this.x = x;
        System.out.println("Called constructor in A");
        System.out.println(x);
    }
    public int m() { return x;}
}
class B extends A {
    public int x;
    public B() { this(2); }
    public B(int x) {
        super(x + 1);
        this.x += super.x + 1;
        System.out.println("this.x= " + this.x);
        System.out.println("Called constructor in B");
    }
    public int m() { return x; }
}

public class Ex {

        public static void main(String[] args) {
            A a;
            B b;
            a = new B();
            //b = (B) a;
            System.out.println(a.x);
            //System.out.println(a.m());
            //System.out.println(b.x);
            //System.out.println(b.m());
        }


}
