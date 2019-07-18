package CodingInterview;

public class _10_Fibonacci {

    public static int fibonacciRecursion(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);

    }

    public static int fibonacciLoop(int n) {
        if (n < 0) return 0;
        if (n == 0) return 0;
        if (n == 1) return 1;
        int fn_2 = 0;
        int fn_1 = 1;
        int fn = 0;
        for (int i = 2; i <= n; ++i) {
            fn = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = fn;
        }
        return fn;
    }

    public static void main(String[] args) {
        System.out.println(fibonacciLoop(10));
        System.out.println(fibonacciRecursion(10));
    }
}
