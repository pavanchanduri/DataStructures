package datastructures;

public class DynamicProgramming {

    //Memoization using Top-down approach
    //This ensures that fibonacci(n-2) calls are not recursively done
    //Instead they are memoized thereby reducing the number of method calls
    static Integer[] memo = new Integer[100];
    public static int fibonacii(int n) {
        if(memo[n]!=null) {
            return memo[n];
        }
        if(n==0||n==1) memo[n] = n;
        else {
            memo[n] = fibonacii(n-1)+fibonacii(n-2);
        }

        return memo[n];
    }

    //Bottom Up Approach of Dynamic Programming
    //We start with the lowest value and go up
    public static int factorial(int n) {

        int[] fact = new int[n+1];
        fact[0] = 1;

        for(int i=1;i<=n;i++) {
            fact[i] = i*fact[i-1];
        }

        return fact[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonacii(5));
        System.out.println(factorial(5));
    }
}
