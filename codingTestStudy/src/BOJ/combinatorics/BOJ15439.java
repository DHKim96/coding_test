package BOJ.combinatorics;

import java.io.*;

public class BOJ15439 {
     /*
        BOJ NO.15439 : 베라의 패션
        조합론 이용
        => N개에서 서로 다른 2개 뽑기 => N * N - 1
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(N * (N - 1)));  // 마지막 공백 제거
        bw.flush();
        bw.close();
        br.close();
    }
}
