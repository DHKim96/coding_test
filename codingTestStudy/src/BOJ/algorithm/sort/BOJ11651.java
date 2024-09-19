package BOJ.algorithm.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11651 {
	/*
	 * BOJ NO.11651 : 좌표 정렬하기2
	 * 
	 * 내장 정렬 메서드 사용 & 람다식과 compare 메소드 사용해 조건부 정렬 구현
	 * 
	 */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        
        // 좌표 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // x
            arr[i][1] = Integer.parseInt(st.nextToken()); // y
        }

        // Arrays.sort를 이용한 좌표 정렬
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {// y좌표가 같을 경우 x좌표 정렬
                return Integer.compare(o1[0], o2[0]); 
            } else { // y좌표 기준 정렬
                return Integer.compare(o1[1], o2[1]); 
            }
        });

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
