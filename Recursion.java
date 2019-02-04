import java.util.ArrayList;

public class Recursion{
    public static double sqrt(double n, double tolerance){
        return NewtonHelper(n, 1, tolerance);
    }
    public static double NewtonHelper(double n, double guess, double tolerance){
        if (n == 0){
            return 0;
        }
        if (Math.abs((guess * guess - n) / n) * 100 <= tolerance){
            return guess;
        }
        return NewtonHelper(n, ((n / guess + guess) / 2), tolerance);
    }
    /*
    public static void main(String[] args){
        System.out.println(sqrt(0,.001));
        System.out.println(sqrt(100,.001));
        System.out.println(sqrt(2,.001));
    }
    */
    public static int fib(int n){
        return fibHelper(n,0,1,1);
    }
    public static int fibHelper(int n, int first, int second, int counter){
        if (n == 0){
            return 0;
        }
        if (n == counter){
            return second;
        }
        return fibHelper(n, second, second + first, counter + 1);
    }
    public static void main(String[] args) {
        System.out.println("sqrt()");
        System.out.println("-----------------------\n");

        System.out.println("sqrt(4, 0.00001)");
        System.out.println("EXPECTED: 2");
        System.out.println(sqrt(4, 0.00001));         // 2

        System.out.println("----");

        System.out.println("sqrt(8, 0.00001)");
        System.out.println("EXPECTED: ~2.8284");
        System.out.println(sqrt(8, 0.00001));         // ~2.8284

        System.out.println("----");

        System.out.println("sqrt(0, 0.00001)");
        System.out.println("EXPECTED: 0");
        System.out.println(sqrt(0, 0.00001));         // 0

        System.out.println("----");

        System.out.println("sqrt(4, 0.0000000000001)");
        System.out.println("EXPECTED: 2");
        System.out.println(sqrt(4, 0.0000000000001));         // 0

        
        System.out.println("----");

        System.out.println("sqrt(2, 0.0000000000001)");
        System.out.println("EXPECTED: 1.41421356237");
        System.out.println(sqrt(2, 0.0000000000001));         // 0


        System.out.println("\n");

        System.out.println("fib()");
        System.out.println("-----------------------\n");

        System.out.println("fib(0)");
        System.out.println("EXPECTED: 0");
        System.out.println(fib(0));                   // 0

        System.out.println("----");

        System.out.println("fib(1)");
        System.out.println("EXPECTED: 1");
        System.out.println(fib(1));                   // 1

        System.out.println("----");

        System.out.println("fib(7)");
        System.out.println("EXPECTED: 13");
        System.out.println(fib(7));                   // 13

        System.out.println("----");

        System.out.println("fib(46)");
        System.out.println("EXPECTED: 1836311903");
        System.out.println(fib(46));                   // 

        /*
        System.out.println("makeAllSums()");
        System.out.println("-----------------------\n");

        System.out.println("makeAllSums(0)");
        System.out.println("EXPECTED: [0]");
        System.out.println(makeAllSums(0));           // [0]

        System.out.println("----");

        System.out.println("makeAllSums(1)");
        System.out.println("EXPECTED: [1, 0]");
        System.out.println(makeAllSums(1));           // [1, 0]

        System.out.println("----");

        System.out.println("makeAllSums(3)");
        System.out.println("EXPECTED: [0, 3, 2, 5, 1, 4, 3, 6]");
        System.out.println(makeAllSums(3));           // [0, 3, 2, 5, 1, 4, 3, 6]
        */
    }
    public static ArrayList<Integer> makeAllSums(int n){
        return new ArrayList<Integer>();
    }
}