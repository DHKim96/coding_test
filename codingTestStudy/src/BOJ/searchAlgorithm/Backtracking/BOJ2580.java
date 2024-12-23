package BOJ.searchAlgorithm.Backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2580 {
    private static int[][] board;
    private static List<int[]> list;
    private static boolean isVaild;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        board = new int[9][9];

        list = new ArrayList<>();

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

        dfs(0);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth){
        if (depth == list.size()){
            if (checkBoard()){
                isVaild = true;
            }
            return;
        }

        int[] blank = list.get(depth);

        int row = blank[0];
        int col = blank[1];

        // 겹치는 게 있는지 없는지 확인? 없으면 입력
        for (int num = 1; num <= 9; num++) {
            if (isVaild(row, col, num)){
                board[row][col] = num;
                dfs(depth + 1);
                if (isVaild){
                    return;
                }
                board[row][col] = 0; // 초기화
            }
        }
    }

    public static boolean isVaild(int row, int col, int num){
        for (int i = 0; i < 9; i++){
            if (board[row][i] == num || board[i][col] == num){
                return false;
            }
        }

        // 3으로 나눈 몫 ~ 몫 + 2

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i <= startRow + 2; i++){
            for (int j = startCol; j <= startCol + 2; j++){
                if (board[i][j] == num){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean checkBoard(){
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
