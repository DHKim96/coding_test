package SSG_coding_test.week5;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14500 {
    /*
        * [BOJ] 테트로미노
        *
        *
        * // 시작점 기준으로 테트로미노 놓기 / 회전
        *
        * straight  (시작점 r,c 일때)
        *   => (12시) [r, c], [r - 1, c], [r - 2, c], [r - 3, c]
        *   => (3시) [r, c], [r, c + 1], [r, c + 2], [r, c + 3]
        *   => (6시) [r, c], [r + 1, c], [r + 2, c], [r + 3, c]
        *   => (9시) [r, c], [r, c - 1], [r, c - 2], [r, c - 3]
        *
        * square
        *   => (12시) (r,c), (r,c+1) (r-1,c) (r-1,c+1)
        *   => (3시) (r,c), (r,c+1) (r+1,c) (r+1,c+1)
        *   => (6시) (r,c), (r,c-1) (r+1,c) (r+1,c-1)
        *   => (9시) (r,c), (r,c-1) (r-1,c) (r-1,c-1)
        *
        * L
        *   // 회전
        *   => (12시) (r,c) (r-1,c) (r-2,c) (r-2,c-1)
        *       => 대칭 (r,c) (r-1,c) (r-2,c) (r-2,c+1)
        *   => (3시) (r,c) (r,c+1) (r,c+2) (r-1,c+2)
        *       => 대칭 (r,c) (r,c+1) (r,c+2) (r+1,c+2)
        *   => (6시) (r,c) (r+1,c) (r+2,c) (r+2,c+1)
        *       => 대칭 (r,c) (r+1,c) (r+2,c) (r+2,c-1)
        *   => (9시) (r,c) (r,c-1) (r,c-2) (r+1,c-2)
        *       => 대칭 (r,c) (r,c-1) (r,c-2) (r-1,c-2)
        *
        * skew
        *   // 회전
        *   => (12시) (r,c) (r-1, c), (r-1, c-1), (r-2, c-1)
        *       => 대칭 (r,c) (r-1, c), (r-1, c+1), (r-2, c+1)
        *   => (3시) (r,c) (r, c+1), (r-1, c+1), (r-1, c+2)
        *		=> 대칭 (r,c) (r, c+1), (r+1, c+1), (r+1, c+2)
        *   => (6시) (r,c) (r+1, c), (r+1, c+1), (r+2, c+1)
        *		=> 대칭 (r,c) (r+1, c), (r+1, c-1), (r+2, c-2)
        *   => (9시) (r,c) (r, c-1), (r+1, c-1), (r+2, c-2)
        *   	=> 대칭 (r,c) (r, c-1), (r-1, c-1), (r-2, c-2)
        *
        * T
        * 	// 회전
        * 	=> 12시 : 
        * 		=> 대칭 : 
        * 	=> 3시 : r,c / r, c+1 / r+1, c+1 / r, c+2
        * 		=> 대칭 :  r,c / r, c+1 / r-1, c+1 / r, c+2
        * 	=> 6시 : r,c / r+1, c / r+1, c-1/ r+2,c
        * 		=> 대칭 : r,c / r+1, c / r+1, c+1/ r+2,c
        * 	=> 9시 : r,c / r, c-1 / r, 
        * 
        * 	
        *
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken()); // 세로
        int M = Integer.parseInt(stk.nextToken()); // 가로

        int[][] paper = new int[N][M];

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        bw.write("");
        bw.flush();
        bw.close();
        br.close();
    }
}
