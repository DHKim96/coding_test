package BOJ.searchAlgorithm.Backtracking;

import java.io.*;

public class BOJ15652 {
    /*
        BOJ NO.15652 : N과 M(4)
            => 백트래킹 근데
                1. 중복 가능
                2. 비내림차순
     */
    
    private static int N; // 자연수 N
    private static int M; // 갯수 M
    private static int[] result; // 수열 담을 배열
    private static StringBuilder sb;

    public static void backtracking(int start, int depth){
        if(depth == M){
            for(int num : result){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 백트래킹 시작
        for(int i = start; i <= N; i++){
            result[depth] = i;
            backtracking(i, depth + 1);
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

        backtracking(1, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
