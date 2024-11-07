package SSG_coding_test.week3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ1092 {
    public static void main(String[] args) throws IOException {
        // 배
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 크레인의 개수
        String[] input = br.readLine().split(" ");
        int[] cranes = new int[N]; // 크레인의 무게 제한 담은 배열
        for (int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(input[i]);
        }

        int M = Integer.parseInt(br.readLine()); // 박스의 개수
        input = br.readLine().split(" ");

        List<Integer> boxes = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(input[i]));
        }

        int answer = solution(cranes, boxes);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }


    public static int solution(int[] cranes, List<Integer> boxes){
        int N = cranes.length;

        // 크레인 배열과 박스 배열 정렬
        Arrays.sort(cranes);
        Collections.sort(boxes, Collections.reverseOrder());

        // 박스의 최대 무게가 크레인이 실을 수 있는 무게보다 크면 옮길 수 없음
        if (cranes[N - 1] < boxes.get(0)) {
            return -1;
        }

        int time = 0;

        // 가장 큰 크레인부터 가장 큰 무게들을 싣게 되면 그게 곧 최적해
        while (!boxes.isEmpty()) {
            int boxIdx = 0;

            for (int i = N - 1; i >= 0 ; i--){
                // 가장 가벼운 박스도 못들면 넘어감
                if(!boxes.isEmpty() && cranes[i] < boxes.get(boxes.size() - 1)) {
                    continue;
                }

                while (boxIdx < boxes.size() && cranes[i] < boxes.get(boxIdx)) {
                    boxIdx++;
                }

                if (boxIdx < boxes.size()) {
                    boxes.remove(boxIdx);
                }

            }

            time++;
        }

        return time;
    }

}
