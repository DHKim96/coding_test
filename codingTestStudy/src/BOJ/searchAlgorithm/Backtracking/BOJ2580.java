package BOJ.searchAlgorithm.Backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2580 {
    private static int[][] board;
    private static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        board = new int[9][9];
        used = new boolean[10];

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


        for (int[] blank : list){
            used = new boolean[10];
            int row = blank[0];
            int col = blank[1];

            // 겹치는 게 있는지 없는지 확인? 없으면 입력

            for (int i = 1; i <= 9; i++){

            }

            int num = 0;

            if (canSearchHorizontal(row)){ // 가로줄 가능 여부
                num = searchHorizontal(row);
            } else if (canSearchVertical(col)){ // 세로줄 가능 여부
                num = searchVertical(col);
            } else { // 정사각형 내에서 찾기
                num = searchSquare(row, col);
            }

            board[row][col] = num;
        }


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

    public static boolean canSearchHorizontal(int row){
        int count = 0;

        for (int i = 0; i < 9; i++){
            if (board[row][i] == 0){
                count++;
            }

            if (count >= 2){
                return false;
            }
        }

        return true;
    }

    public static boolean canSearchVertical(int col){
        int count = 0;

        for (int i = 0; i < 9; i++){
            if (board[i][col] == 0){
                count++;
            }

            if (count >= 2){
                return false;
            }
        }

        return true;
    }

    public static int searchHorizontal(int row){
        for (int i = 0; i < 9; i++){
            int num = board[row][i];

            if (num != 0){
                used[num] = true;
            }
        }

        return calcNum();
    }

    public static int searchVertical(int col){
        for (int i = 0; i < 9; i++){
            int num = board[i][col];

            if (num != 0){
                used[num] = true;
            }
        }

        return calcNum();
    }

    public static int searchSquare(int row, int col){
        // 3으로 나눈 몫 ~ 몫 + 2

        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;

        for (int i = startRow; i <= startRow + 2; i++){
            for (int j = startCol; j <= startCol + 2; j++){
                int num = board[i][j];

                if (num != 0){
                    used[num] = true;
                }
            }
        }

        return calcNum();
    }

    public static int calcNum(){
        for (int i = 1; i <= 9; i++){
            if (!used[i]){
                return i;
            }
        }

        return -1;
    }
}
