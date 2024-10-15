package BOJ.searchAlgorithm.Backtracking;

import java.io.*;

public class BOJ9663 {
    private static int N; // 체스판 크기
    private static int count; // 경우의 수
    private static boolean[] column;         // 열 체크 배열
    private static boolean[] leftDiagonal;   // 좌상향 대각선 체크 배열
    private static boolean[] rightDiagonal;  // 우상향 대각선 체크 배열

    public static void backtracking(int row) {
        if (row == N) { // 모든 행에 퀸을 배치한 경우
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (!column[col] && !leftDiagonal[row - col + N - 1] && !rightDiagonal[row + col]) {
                // 현재 위치에 퀸을 놓음
                column[col] = true;
                leftDiagonal[row - col + N - 1] = true;
                rightDiagonal[row + col] = true;

                // 다음 행으로 이동
                backtracking(row + 1);

                // 상태 복구
                column[col] = false;
                leftDiagonal[row - col + N - 1] = false;
                rightDiagonal[row + col] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        count = 0;
        column = new boolean[N];
        leftDiagonal = new boolean[2 * N - 1];
        rightDiagonal = new boolean[2 * N - 1];

        backtracking(0);

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
