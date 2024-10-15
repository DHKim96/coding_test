package BOJ.searchAlgorithm.Backtracking;

import java.io.*;
import java.util.*;

public class BOJ14888 {
    /*
        BOJ NO.14888 : 연산자 끼워넣기
        
        => 백트래킹(연산자만)
     */
    private static int N; // 수의 개수
    private static int[] numbers; // 숫자 저장하는 배열
    private static int[] operations;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void backtracking(int currentResult, int depth) {
        if (depth == N) { // 숫자의 갯수만큼 반복
            // 최댓값, 최솟값 계산
            max = Math.max(max, currentResult);
            min = Math.min(min, currentResult);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(operations[i] > 0){
                operations[i]--;

                switch (i){
                    case 0:
                        backtracking(currentResult + numbers[depth], depth + 1);
                        break;
                    case 1:
                        backtracking(currentResult - numbers[depth], depth + 1);
                        break;
                    case 2:
                        backtracking(currentResult * numbers[depth], depth + 1);
                        break;
                    case 3:
                        if(currentResult < 0){
                            backtracking(-(Math.abs(currentResult) / numbers[depth]), depth + 1);
                        } else {
                            backtracking(currentResult / numbers[depth], depth + 1);
                        }
                }

                // 탈출 후 연산자 숫자 복구
                operations[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 1. 숫자 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); // 수의 개수

        numbers = new int[N]; // 수를 저장할 배열

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken()); // 수 입력 받기
        }

        operations = new int[4]; // 연산자 넣을 배열

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) { // 연산자의 개수 입력 받기(+ - * /)
            operations[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(numbers[0], 1);

        bw.write(max + "\n" + min);
        bw.flush();
        bw.close();
        br.close();

    }
}
