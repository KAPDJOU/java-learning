package OCP;

public class Chap1_NestedClass {
    public static void main(String args[]) {
    }
}

// @formatter:off


/** Member Inner Classes */

class Outer {
    private String greeting = "Hi";

    protected class Inner {
        public int repeat = 3;

        public void go() {
            for (int i = 0; i < repeat; i++)
                System.out.println(greeting);
        }
    }

    public void callInner() {
        Inner inner = new Inner();
        inner.go();
    }

    public static void main(String[] args) {
        Outer outer1 = new Outer();
        outer1.callInner(); // Hi Hi Hi

        // another way to instantiate Inner
        Outer outer2 = new Outer();
        Inner inner = outer2.new Inner(); // create the inner class
        inner.go(); // Hi Hi Hi
    }
}

class A {
    private int x = 10;
    class B {
        private int x = 20;
        class C {
            private int x = 30;
            public void allTheX() {
                System.out.println(x); // 30
                System.out.println(this.x); // 30
                System.out.println(B.this.x); // 20
                System.out.println(A.this.x); // 10
            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new B();
        A.B.C c = b.new C();
        c.allTheX();
        // or
        // A.B.C c2 = new A().new B().new C();
        // c2.allTheX();
    }
}


/** Local Inner Classes */

class Outer2 {
    private int length = 5;

    public void calculate() {
        final int width = 20;
        class Inner {
            public void multiply() {
                System.out.println(length * width);
            }
        }
        Inner inner = new Inner();
        inner.multiply();
    }

    public static void main(String[] args) {
        Outer2 outer = new Outer2();
        outer.calculate(); // 100
    }
}

/** Anonymous Inner Classes */

// extending abstract class
class AnonInner1 {
    abstract class SaleTodayOnly {
        abstract int dollarsOff();
    }
    public int admission(int basePrice) {
        SaleTodayOnly sale = new SaleTodayOnly() {
            int dollarsOff() { return 3;}
        };
        return basePrice - sale.dollarsOff();
    }
}
// implement interface
class AnonInner2 {
    interface SaleTodayOnly {
        int dollarsOff();
    }
    public int admission(int basePrice) {
        SaleTodayOnly sale = new SaleTodayOnly() {
            public int dollarsOff() { return 3; }
        };
        return basePrice - sale.dollarsOff();
    }
}
// define them where they are needed, even if that is an argument to another method:
class AnonInner3 {
    interface SaleTodayOnly {
        int dollarsOff();
    }
    public int pay() {
        return admission(5, new SaleTodayOnly() {
            public int dollarsOff() { return 3; }
        });
    }
    public int admission(int basePrice, SaleTodayOnly sale) {
        return basePrice - sale.dollarsOff();
    }
}

/** Static Nested Classes */
class Enclosing {
    static class Nested {
        private int price = 6;
    }
    public static void main(String[] args) {
       Nested nested = new Nested();
       System.out.println(nested.price);
    } 
}

//@formatter:on