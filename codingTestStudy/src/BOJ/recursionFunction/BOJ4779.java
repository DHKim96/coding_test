package BOJ.recursionFunction;

import java.io.*;

public class BOJ4779 {
    /*
        * 칸토어 집합
        *   : 0, 1 사이의 실수로 이루어진 집합
        *   [0,1] 부터 시작해서 각 구간을 3등분하여 가운데 구간을 반복적으로 제외하는 방식
        *
     */

    static char[] s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = null;

        StringBuilder sb = new StringBuilder();

        // 입력이 null이 아닐 때까지 읽음
        while ((input = br.readLine()) != null && !input.isEmpty()) {

            int n = Integer.parseInt(input);

            // 배열 크기 설정 (0부터 시작)
            int num = (int) Math.pow(3, n);  // 3^n 크기
            s = new char[num];  // 0부터 사용하도록 num 크기의 배열 설정

            // 배열을 모두 '-'로 채움
            for (int i = 0; i < num; i++) {
                s[i] = '-';
            }

            // 칸토어 집합 생성
            cantor(0, num);

            // 결과를 StringBuilder에 추가
            sb.append(s).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void cantor(int start, int size){
        // 재귀 탈출 조건
        if (size == 1){
            return;
        }

        int mid = start + size / 3; // 10
        int right = mid + size / 3;

        // 중간 공백 처리
        for (int i = mid; i < right; i++){ // 10 ~ 18
            s[i] = ' ';
        }

        // 좌
        cantor(start, size / 3);

        // 우
        cantor(right, size / 3);

    }
}
