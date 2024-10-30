package PROGRAMMERS.greedy;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] students = new int[n + 1]; // 1번 학생부터 존재

        for (int l : lost){
            students[l]--; // => 도난당한 학생은 -1
        }

        for (int r : reserve){
            students[r]++; // => 여벌 옷 존재하는 학생은 +1 => 여벌 옷 가진 학생 중 도난 당할 시 0
        }

        for (int i = 1; i <= n; i++){
            if (students[i] >= 0) answer++;

            if (students[i] == 1) { // +1 인 학생만 옷을 빌려 줄 수 있음
                int left = i - 1;
                int right = i + 1;

                if (left >= 1 && students[left] == -1) {
                    students[left]++;
                    answer++;
                }
                else if (right <= n && students[right] == - 1) {
                    students[right]++;
                    // 오른쪽 인덱스는 다음에 순회하기 때문에 answer++ 하지 않음
                }
            }

        }

        return answer;
    }
}
