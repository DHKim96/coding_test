package BOJ.combinatorics;

import java.io.*;

public class BOJ11050 {
     /*
        BOJ NO.11050 : 이항 계수 1
        순서 없는 조합(같은 것이 있는 순열)의 가짓수

        n! / r!(n-r)!

     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int result = pactorial(N) / (pactorial(K) * pactorial(N - K));


        bw.write(String.valueOf(result));  // 마지막 공백 제거
        bw.flush();
        bw.close();
        br.close();
    }

    public static int pactorial(int N){
        if(N <= 0) return 1;
        return N * pactorial(--N);
    }
}
