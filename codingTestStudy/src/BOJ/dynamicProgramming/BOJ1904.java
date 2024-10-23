package BOJ.dynamicProgramming;

import java.util.Scanner;

public class BOJ1904 {
    /*
        * 01타일
        *   만들 수 있는 모든 가짓수를 세는 것
        *   DP
        *   => n개의 타일을 만드는 방법은 n-1개의 타일 뒤에 1을 붙이거나 n-2개의 타일 뒤에 00을 붙이는 경우의 수와 같음
        *   시간 제한 0.75초
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 자연수 N

        System.out.println(calcTile(N));

        sc.close();
    }

    public static int calcTile(int N){
        if (N == 1) return 1;
        if (N == 2) return 2;

        int prev1 = 1;
        int prev2 = 2;
        int curr = 0;

        for(int i = 3; i <= N; i++){
            curr = (prev1 + prev2); // 매번 15746으로 나눈 나머지 저장
            prev1 = prev2;
            prev2 = curr;
        }

        return curr;
    }
}
