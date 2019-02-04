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
}