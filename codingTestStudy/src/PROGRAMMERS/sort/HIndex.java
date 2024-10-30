package PROGRAMMERS.sort;

import java.util.Arrays;

public class HIndex {
    public int solution(int[] citations) {
        // 1. 오름차순 정렬
        Arrays.sort(citations);

        int answer = 0;
        for (int i = 0; i < citations.length; i++) {
            int hIndexCandidate = citations.length - i;
            if (citations[i] >= hIndexCandidate) {
                answer = hIndexCandidate;
                break; // 조건을 만족하는 가장 큰 값을 찾았으므로 반복 종료
            }
        }

        return answer;
    }
}
