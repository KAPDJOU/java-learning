package centraltest;

public class TestTryCatchFinally {
    static int x = 0;

    public static void main(String[] args){
        System.out.println("f1()= " + f1() ); // 1
        System.out.println("f2()= " + f2() ); // 2
    }

    public static int f1(){
        try{
            x = 1;
            return x;
        }finally{
            x = 2;
        }
    }

    public static int f2(){
        return x;
    }
}
