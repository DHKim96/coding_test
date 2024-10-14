package BOJ.combinatorics;

import java.io.*;

public class BOJ24723 {
    /*
        BOJ NO.24723 : 녹색 거탑
        조합론 이용
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int result = 1;

        for(int i = 0; i < N; i++) {
            result *= 2;
        }

        bw.write(String.valueOf(result));  // 마지막 공백 제거
        bw.flush();
        bw.close();
        br.close();
    }
}
