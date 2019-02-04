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
    public static void main(String[] args){
        System.out.println(sqrt(0,.001));
        System.out.println(sqrt(100,.001));
        System.out.println(sqrt(2,.001));
    }
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
}