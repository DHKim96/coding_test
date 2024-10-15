package BOJ.searchAlgorithm.Backtracking;

import java.io.*;

public class BOJ14889 {
    private static int N;
    private static int[][] S;
    private static boolean[] visited;
    private static int min = Integer.MAX_VALUE;

    public static void backtracking(int idx, int depth) {
        if (depth == N / 2) { // 팀을 절반으로 나누면
            int start = 0;
            int link = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i] && visited[j]) { // 스타트 팀
                        start += S[i][j];
                    } else if (!visited[i] && !visited[j]) { // 링크 팀
                        link += S[i][j];
                    }
                }
            }

            min = Math.min(min, Math.abs(start - link));
            return;
        }

        // 모든 조합 탐색
        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(row[j]);
            }
        }

        visited = new boolean[N];
        backtracking(0, 0);

        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
