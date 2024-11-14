package SSG_coding_test.week5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ17140{
    /*
        [BOJ]17140 : 이차원 배열과 연산

        1. 크기 3 x 3 고정
        2. 인덱스 1부터 시작
        3. 1초마다 연산 적용
            3.1. R연산 : 모든 행 정렬(단, 행의 개수 >= 열의 개수인 경우만 적용)
            3.2. C연산 : 모든 열 정렬(단, 행의 개수 < 열의 개수인 경우만 적용)
        4. 각각의 수가 몇 번 나왔는지 확인
        5. 수의 등장 횟수 오름차순
        6. 수의 크기 오름차순
        7. 정렬된 결과 다시 넣기
            7.1. 수, 등장 횟수 모두 넣기(수 -> 등장횟수 순서로)
            7.2. 행/열의 크기가 100을 넘어가게 될 때 처음 100개 제외한 나머지는 버림
            7.3. 연산 결과 행/열의 크기가 달라질 경우 크기가 커진 곳에는 0 삽입(정렬시는 0 무시)
        8. A[r][c] = k 가 되는 시간 구하기(단, 100초가 지나도 되지 않을 시 -1 출력)


        연산 시마다 배열의 크기가 동적으로 계속 변함
    */

    public static int[][] A;
    public static int time;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(stk.nextToken()) - 1;
        int c = Integer.parseInt(stk.nextToken()) - 1;
        int k = Integer.parseInt(stk.nextToken());

        A = new int[3][3]; // 인덱스는 1부터 시작
        time = 0;

        for (int i = 0; i < 3; i++){
            stk = new StringTokenizer(br.readLine());

            A[i][0] = Integer.parseInt(stk.nextToken());
            A[i][1] = Integer.parseInt(stk.nextToken());
            A[i][2] = Integer.parseInt(stk.nextToken());
        }

        int result = -1;

        while(time < 100){
            if (check(r, c, k)) {
                result = time;
                break;
            }

            if (canR()){
                R(r, c, k);
            } else {
                C(r, c, k);
            }

            time++;
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();

    }
    public static boolean check(int r, int c, int k){
        return r < A.length && c < A[r].length && A[r][c] == k;
    }

    // R연산인지 C연산인지 확인
    public static boolean canR(){
        return A.length >= A[1].length;
    }

    // R연산 => 열 증가
    public static void R(int r, int c, int k){ // 행을 기준으로 정렬하기
        int[] composition = new int[101]; // 숫자는 최대 100개

        List<List<int[]>> list = new ArrayList<>();

        int maxSize = 0;

        for (int i = 0; i < A.length; i++){
            List<int[]> row = new ArrayList<>();

            for (int j = 0; j < A[1].length; j++){
                composition[A[i][j]]++;
            }

            for (int j = 1; j <= 100; j++){
                if(composition[j] > 0){ // j = 수 / composition[j] = j의 등장 횟수
                    row.add(new int[]{j, composition[j]});
                }
            }

            maxSize = Math.max(maxSize, 2 * row.size());

            Collections.sort(row, (o1, o2) -> {
                // 등장 횟수 오름차순, 같으면 수의 오름차순
                return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
            });

            list.add(row);

            composition = new int[101]; // 숫자는 최대 100개
        }

        sort(A.length, maxSize, list, true, r, c, k);
    }

    // C연산 => 행이 증가함
    public static void C(int r, int c, int k){
        int[] composition = new int[101]; // 숫자는 최대 100개

        List<List<int[]>> list = new ArrayList<>();

        int maxSize = 0;

        for (int i = 0; i < A[1].length; i++){
            List<int[]> col = new ArrayList<>();

            for (int j = 0; j < A.length; j++){
                composition[A[j][i]]++;
            }

            for (int j = 1; j <= 100; j++){
                if(composition[j] > 0){ // j = 수 / composition[j] = j의 등장 횟수
                    col.add(new int[]{j, composition[j]});
                }
            }

            maxSize = Math.max(maxSize, 2 * col.size());

            Collections.sort(col, (o1, o2) -> {
                // 등장 횟수 오름차순, 같으면 수의 오름차순
                return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
            });

            list.add(col);

            composition = new int[101]; // 숫자는 최대 100개
        }

        sort(maxSize, A[1].length, list, false, r, c, k);
    }

    // 정렬된 결과로 배열 새로 만들기
    public static void sort(int row, int col, List<List<int[]>> list, boolean isR, int r, int c, int k){
        row = Math.min(row, 100);
        col = Math.min(col, 100);

        A = new int[row][col];

        if (isR){ // 행 정렬
            for (int i = 0; i < list.size(); i++){

                List<int[]> l = list.get(i);

                if (i > 100) break;

                for (int j = 0; j < l.size(); j++){

                    if (2*j + 1 > 100) break;

                    int[] arr = l.get(j);
                    A[i][2 * j] = arr[0];
                    A[i][2 * j + 1] = arr[1];
                }
            }
        } else { // 열 정렬
            for (int i = 0; i < list.size(); i++){

                List<int[]> l = list.get(i);

                if (i > 100) break;

                for (int j = 0; j < l.size(); j++){

                    if (2*j + 1 > 100) break;

                    int[] arr = l.get(j);
                    A[2*j][i] = arr[0];
                    A[2*j + 1][i] = arr[1];
                }
            }
        }
    }
}