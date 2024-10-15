package BOJ.searchAlgorithm.Backtracking;

import java.io.*;

public class BOJ15651 {
    /*
        BOJ NO.15651 : N과 M (3)
            => 백트래킹 근데 중복이 가능한
     */

    private static int N; // 자연수 N
    private static int M; // 길이 M
    private static int[] result; // 수열 담을 배열
    private static StringBuilder sb;

    public static void backtracking(int depth){
        if(depth == 0){
            for(int num : result){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            result[M - depth] = i;
            backtracking(depth - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        result = new int[M];
        sb = new StringBuilder();

        backtracking(M);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
