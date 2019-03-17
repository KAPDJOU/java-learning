package co.edureka;

class A {
    static int i = 100;

    static {
	i = i-- - --i; // 100 - 98
	System.out.println("Frist " + i); // = 2
    }

    {
	i = i++ + ++i; // 0 + 2
	System.out.println("Second " + i); // = 2
    }
}

class B extends A {

    static {
	i = --i - i--; // (2-1) - (2-1) = 1 - 1 
	System.out.println("Third " + i); // = 0
    }

    {
	i = ++i + i++; // (2+1) + 3 = 3 + 3 
	System.out.println("Fourth " + i); // = 6
    }
}

public class Q20 {

    public static void main(String[] args) {
	B b = new B();
	System.out.println(b.i); // 6
    }

}
