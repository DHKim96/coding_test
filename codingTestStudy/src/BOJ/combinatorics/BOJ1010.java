package BOJ.combinatorics;

import java.io.*;

public class BOJ1010 {
        /*
        BOJ NO.1010 : 다리 놓기
     */

    public static long combination(int n, int r){
        if (n == r || r == 0) return 1;
        if (r > n / 2) r = n - r; // 조합의 대칭성 활용

        long result = 1;

        for(int i = 0; i < r; i++){
            result *= (n - i);
            result /= (i + 1);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스 개수 입력 받기
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            // 서쪽 사이트의 개수
            int N = Integer.parseInt(input[0]);
            // 동쪽 사이트의 개수
            int M = Integer.parseInt(input[1]);

            sb.append(combination(M, N)).append("\n");
        }

        bw.write(sb.toString());  // 마지막 공백 제거
        bw.flush();
        bw.close();
        br.close();
    }
}
