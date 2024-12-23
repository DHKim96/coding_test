package BOJ.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        int[][] matrixSizes = new int[N][2];

        for (int i = 0; i < N; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            matrixSizes[i][0] = Integer.parseInt(stk.nextToken());
            matrixSizes[i][1] = Integer.parseInt(stk.nextToken());
        }

        if (N == 1){
            System.out.println(answer);
            br.close();
            return;
        }

        // 행렬의 크기 => 곱셈에 대한 결합법칙 성립하기 때문에 순서에 따라 결과가 달라지지 않음 즉, 순서에 따라 크기 변하지 않음
        // 그러나 연산횟수는 달라짐

        int[] dp = new int[N];

        dp[0] = 0;
        dp[1] = matrixSizes[0][0] * matrixSizes[0][1] * matrixSizes[1][1];

        for (int i = 2; i < N; i++){
            dp[i] = calcMin(i, dp, matrixSizes);
        }

        System.out.print(dp[N-1]);

        br.close();
    }

    public static int calcMin(int idx, int[] dp, int[][] matrixSize){
        int res1 = dp[idx-1] + matrixSize[idx - 2][0] * matrixSize[idx - 1][1] * matrixSize[idx][1];
        int res2 = matrixSize[idx-1][0] * matrixSize[idx][0] * matrixSize[idx][1] + matrixSize[idx-2][0] * matrixSize[idx-1][0] * matrixSize[idx][1];

        return Math.min(res1, res2);
    }
}
