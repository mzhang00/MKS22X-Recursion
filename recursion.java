import java.util.ArrayList;

public class recursion{
    public static double sqrt(double n, double tolerance){
        return NewtonHelper(n, 1, tolerance);
    }
    private static double NewtonHelper(double n, double guess, double tolerance){
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
    private static int fibHelper(int n, int first, int second, int counter){
        if (n == 0){
            return 0;
        }
        if (n == counter){
            return second;
        }
        return fibHelper(n, second, second + first, counter + 1);
    }
    public static void main(String[] args) {
        /*System.out.println("sqrt()");
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
        
        System.out.println("----");

        System.out.println("makeAllSums(4)");
        System.out.println("EXPECTED: [0, 3, 2, 5, 1, 4, 3, 6, 4, 7, 6, 9, 5, 8, 7, 10]");
        System.out.println(makeAllSums(4));*/
        for (int i = 0; i <= 5; i++){
            testFib(i);
            if (i != 5){
                testSqrt(i);
            }
        }
    }

    public static ArrayList<Integer> makeAllSums(int n){
        ArrayList<Integer> result = new ArrayList<>();
        masHelper(result, n, 0);
        return result;
    }
    private static void masHelper(ArrayList<Integer> a, int n, int leftover){
        if (n == 0){
            a.add(leftover);
        }else{
            masHelper(a, n - 1, leftover);
            masHelper(a, n - 1, leftover + n);
        }
    }

    public static boolean closeEnough(double a, double b){
        if(a==0.0 && b==0.0)return true;
        if(a==0.0)return b < 0.00000000001;
        if(b==0.0)return a < 0.00000000001;
        return Math.abs(a-b)/a < 0.0001;//This is the normal % difference allowed
    
    }
    
    
    //testcase must be a valid index of your input/output array
    public static void testFib(int testcase){
      recursion r = new recursion();
      int[] input = {0,1,2,3,5,30};
      int[] output ={0,1,1,2,5,832040};
      int max = input.length;
      if(testcase < input.length){
        int in = input[testcase];
        try{
          
          int ans = r.fib(in);
          int correct = output[testcase];
          if(ans == correct){
            System.out.println("PASS test fib "+in+". "+correct);
          }
          else{
            System.out.println("FAIL test fib"+in+". "+ans+" vs "+correct);
            
          }
        }catch(IllegalArgumentException n){
          if(in < 0){
            System.out.println("PASS test fib"+in+" IllegalArgumentException");
          }else{
            System.out.println(" FAIL IllegalArgumentException in test case:"+in);
          }
        }catch(Exception e){
          System.out.println(" FAIL Some exception in test case:"+in);
        }
      }
    }
    
    
    //testcase must be a valid index of your input/output array
    public static void testSqrt(int testcase){
      recursion r = new recursion();
      double[] input = {0.0,1.0, 2.0, 4.0, 7.0};
      double[] output = {0.0,1.0,1.4142135623730951,2.0,2.6457513110645907};
      int max = input.length;
      if(testcase < input.length){
        double in = input[testcase];
        try{
          
          double ans = r.sqrt(in,.00001);
          double correct = Math.sqrt(in);
          if(closeEnough(ans,correct)){
            System.out.println("PASS test sqrt "+in+" "+ans);
          }
          else{
            System.out.println("FAIL test sqrt "+in+" "+ans+" vs "+correct);
            
          }
        }catch(IllegalArgumentException n){
          if(in < 0){
            System.out.println("PASS test sqrt"+in+" IllegalArgumentException");
          }else{
            System.out.println(" FAIL IllegalArgumentException in test case:"+in);
          }
        }catch(Exception e){
          System.out.println(" FAIL Some exception in test case:"+in);
        }
      }
    }
}