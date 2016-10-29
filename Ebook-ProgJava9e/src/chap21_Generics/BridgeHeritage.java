package chap21_Generics;

// @formatter:off

// simpel case to test polymorphism with generic 

public class BridgeHeritage {
    public static void main(String args[]) {        
    }
}

class Bridge {
	public static void main(String args[]) {
	    
		A<Double> ad = new A<Double>();
		A<Integer> ai = new A<Integer>();
		C<Integer, String> c = new C<>();
		B b = new B();
		Double d = new Double(2.5);
		Integer i = new Integer(2);
		
		ad.f(d);// appel A.f
		ai.f(i); // appel A.f
		b.f(i); // appel B.f
		
		ai = b;
		ai.f(i); // appel B.f
		
		ai = c;
		ai.f(i); // appel C.f
	}
}

class A<T> {
	void f(T x) {
		System.out.println("appel A.f");
	}
}

class B extends A<Integer> {
	void f(Integer i) {
		System.out.println("appel B.f");
	}
}


class C<T, U> extends A<T> { 
    void f(T x) {
        System.out.println("appel C.f");
    }
}
class D<T> extends A<T> { }
class E<T extends Number> extends A<T> { }