package BOJ.dynamicProgramming;

import java.util.Scanner;

public class BOJ24416 {
    /*
        * 알고리즘 수업 - 피보나치 수 1
            : DP
     */
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        count = 1;

        int recursion = fib(n);

        int recursionRes = count;

        count = 0;

        int dp = fibonacci(n);

        int deResult = count;

        System.out.printf("%d %d", recursionRes, deResult);

        sc.close();
    }

    // 재귀 함수로 구현한 피보나치 수열
    public static int fib(int n) {
        if (n <= 2) return 1;
        count++;
        return fib(n - 1) + fib(n - 2);
    }

    public static int fibonacci(int n) {
        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 1;

        for (int i = 3; i <= n; i++) {
            count++;
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }
}
