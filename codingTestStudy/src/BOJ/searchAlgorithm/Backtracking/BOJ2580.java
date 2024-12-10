package BOJ.searchAlgorithm.Backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2580 {
    private static int[][] board;
    private static int[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        board = new int[9][9];

        List<int[]> list = new ArrayList<>();

        // 스도쿠 판 입력 받기
        for (int i = 0; i < 9; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++){
                int num = Integer.parseInt(stk.nextToken());
                board[i][j] = num;
                if (num == 0 ){
                    list.add(new int[]{i, j});
                }
            }
        }

        dfs(list, 0, 0);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                sb.append(board[i][j]).append(" ");
            }

            if (i != 8){
                sb.append("\n");
            }
        }

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(List<int[]> list, int startIdx, int depth){
        if (depth == list.size()){
            return;
        }

        for (int i = startIdx; i < list.size(); i++) {
            int[] blank = list.get(i);

            int row = blank[0];
            int col = blank[1];

            // 겹치는 게 있는지 없는지 확인? 없으면 입력
            for (int num = 1; num <= 9; num++) {
                board[row][col] = num;

                if (canSearchHorizontal(row) && canSearchVertical(col) && canSearchSquare(row, col)) {
                    dfs(list, i + 1, depth + 1);
                    if (isPossible()){
                        return;
                    }
                }

                board[row][col] = 0;
            }

            if (!isPossible()){
                return;
            }
        }
    }

    public static boolean canSearchVertical(int col){
        used = new int[10];

        for (int i = 0; i < 9; i++){
            used[board[i][col]]++;
        }

        return canUse();
    }


    public static boolean canSearchHorizontal(int row){
        used = new int[10];

        for (int i = 0; i < 9; i++){
            used[board[row][i]]++;
        }
        return canUse();
    }


    public static boolean canSearchSquare(int row, int col){
        used = new int[10];
        // 3으로 나눈 몫 ~ 몫 + 2

        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;

        for (int i = startRow; i <= startRow + 2; i++){
            for (int j = startCol; j <= startCol + 2; j++){
               used[board[i][j]]++;
            }
        }

        return canUse();
    }

    public static boolean canUse(){

        for (int i = 1; i <= 9; i++){
            if (used[i] > 1){
                return false;
            }
        }

        return true;
    }

    public static boolean isPossible(){
        for (int[] row : board){
            for (int col : row){
                if (col < 1){
                    return false;
                }
            }
        }

        return true;
    }
}
