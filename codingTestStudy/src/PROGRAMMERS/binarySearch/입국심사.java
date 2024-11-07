package PROGRAMMERS.binarySearch;

import java.util.Arrays;

public class 입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;

        // times 배열 오름차순 정렬
        Arrays.sort(times);

        // 소요 시간의 최솟값
        long left = 1;

        // 소요 시간의 최댓값 = 가장 오래 걸리는 심사관의 심사 시간 * 인원 수
        long right = (long)times[times.length - 1] * n;
        answer = right;

        while(left <= right){
            long mid = (left + right) / 2; // 현재 시간
            long totalPeople = 0; // mid 시간 동안 처리할 수 있는 인원 수

            for (int time : times){
                totalPeople += mid / time; // mid 시간 동안 심사관이 처리할 수 있는 인원 수 증가
            }

            if (totalPeople >= n){ // mid 시간동안 처리 가능하다면
                answer = mid; // 현재 시간 저장
                right = mid - 1; // mid 보다 더 작은 범위에서 탐색
            } else { // 처리 불가하다면
                left = mid + 1; // mid 보다 더 큰 범위에서 탐색
            }
        }

        return answer;
    }
}
