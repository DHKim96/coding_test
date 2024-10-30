package PROGRAMMERS.bruteForce;

public class 피로도 {
    private boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];  // 방문 여부 배열 초기화
        return searchDungeons(k, dungeons, 0);  // 던전 탐험 시작
    }

    public int searchDungeons(int k, int[][] dungeons, int count) {
        // 현재 탐험한 던전 수를 저장
        int maxCount = count;

        // 던전 탐험 가능한지 확인
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {  // 탐험 조건: 피로도가 던전의 최소 필요 피로도 이상일 때
                visited[i] = true;  // 던전 방문 처리
                maxCount = Math.max(maxCount, searchDungeons(k - dungeons[i][1], dungeons, count + 1));  // 재귀 탐험
                visited[i] = false;  // 백트래킹: 방문 해제
            }
        }

        return maxCount;  // 최대 탐험한 던전 수 반환
    }
}
