package BOJ.combinatorics;

import java.io.*;

public class BOJ10872 {
        /*
        BOJ NO.10872 : 팩토리얼
        재귀 이용
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(pactorial(N)));  // 마지막 공백 제거
        bw.flush();
        bw.close();
        br.close();
    }

    public static int pactorial(int N){
        if(N <= 0) return 1;
        return N * pactorial(--N);
    }
}
