package PROGRAMMERS.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디스크컨트롤러 {
    public int solution(int[][] jobs) {
        int answer = 0;

        // 먼저 요청이 들어온 작업부터 처리하되 대기 큐에 작업 소요 시간을 오름차순으로 우선순위를 부여하면 어떨까
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        // 요청 시간을 기준으로 정렬
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        int idx = 0;
        int seconds = 0;
        int endWork = 0;

        while(endWork < jobs.length){

            // 현 시점에 맞게 요청 들어온 작업들을 대기 큐에 삽입
            while (idx < jobs.length && jobs[idx][0] <= seconds){
                queue.add(jobs[idx++]);
            }

            // 대기 중인 작업이 있다면 꺼내 처리
            if (!queue.isEmpty()){
                int[] currJob = queue.poll(); // 작업 실시

                seconds += currJob[1]; // 작업 종료 시점 반영

                // 요청 시점부터 종료 시점까지의 시간 누적
                answer += seconds - currJob[0];
                System.out.print(answer);
                endWork++;
            } else {
                // 대기 중인 작업이 없다면 다음 작업이 요청되는 시점으로 이동
                if (idx < jobs.length){
                    seconds = jobs[idx][0];
                }

            }

        }


        return answer / jobs.length;
    }
}
