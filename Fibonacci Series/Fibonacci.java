import java.util.Scanner;
class Fibonacci {

    public static void allFib(int n) {
        int[] memo = new int[n+1];
        for (int i=0; i<n; i++) {
            System.out.println((i+1) + " : " + fib(i, memo));
        }
    }

    public static int fib(int n, int memo[]) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (memo[n] > 0) {
            return memo[n];
        }

        memo[n] = fib(n-1, memo) + fib(n-2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        try {
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            allFib(n);
        } catch (Exception e) {
           e.printStackTrace(); 
        }
        

    }
}