class C1 {
    public String toString(){
        return "C1";
    }
}

class C11 extends C1 {
    public String toString(){
        return "C11";
    }
}

class C2 {
    C1 proces(){
        return new C1();
    }
}

class C21 extends C2 {
    C11 proces() {
        return new C11();
    }
}

public class Teste {
    public static void main(String[] args) {
        C2 m = new C2();
        C1 g = m.proces();
        System.out.println(g);
        m = new C21();
        g = m.proces();
        System.out.println(g);
    }
}