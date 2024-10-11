package BOJ.dataStructure.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class BOJ24511 {
	/*
    BOJ NO.24511 : queuestack
 */

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] queuestack = new int[N];
    LinkedList<Integer> queueValues = new LinkedList<>(); // 큐 역할을 할 리스트

    String[] A = br.readLine().split(" ");
    String[] B = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
        int num = Integer.parseInt(B[i]);
        queuestack[i] = num;
        // 수열 A의 값이 0인 경우만 큐로 추가
        if (Integer.parseInt(A[i]) == 0) {
            queueValues.add(num);
        }
    }

    int M = Integer.parseInt(br.readLine());
    String[] C = br.readLine().split(" ");
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < M; i++) {
        int num = Integer.parseInt(C[i]);

        if (!queueValues.isEmpty()) {
            queueValues.addFirst(num);      // 새 값 삽입
            num = queueValues.removeLast(); // 기존 값 반환
        }
        
        sb.append(num).append(" ");
    }

    bw.write(sb.toString().trim());  // 마지막 공백 제거
    bw.flush();
    bw.close();
    br.close();
}
}
