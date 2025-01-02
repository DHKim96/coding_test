package SSG_coding_test.week8;

import java.io.*;
import java.util.*;

public class BOJ1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken()); // 학생 수 (노드 수)
        int M = Integer.parseInt(stk.nextToken()); // 도로 수 (간선 수)
        int X = Integer.parseInt(stk.nextToken()); // 파티가 열리는 마을 번호

        // 그래프 초기화
        List<List<int[]>> graph = new ArrayList<>();
        List<List<int[]>> reverseGraph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            int time = Integer.parseInt(stk.nextToken());

            graph.get(start).add(new int[]{end, time}); // 단방향 그래프
            reverseGraph.get(end).add(new int[]{start, time}); // 역방향 그래프
        }


        System.out.println(solution(graph, reverseGraph, X, N));
    }

    private static int solution(List<List<int[]>> graph, List<List<int[]>> reverseGraph, int X, int N){
        // X에서 모든 노드로 가는 최단 거리
        int[] distFromX = dijkstra(graph, X, N);

        // 모든 노드에서 X로 오는 최단 거리
        int[] distToX = dijkstra(reverseGraph, X, N);

        // 왕복 거리 계산
        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, distFromX[i] + distToX[i]);
        }

        return maxTime;
    }

    private static int[] dijkstra(List<List<int[]>> graph, int start, int N) {
        int[] distances = new int[N + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDist = current[1];

            if (currentDist > distances[currentNode]) continue;

            for (int[] neighbor : graph.get(currentNode)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDist = currentDist + weight;

                if (newDist < distances[nextNode]) {
                    distances[nextNode] = newDist;
                    pq.add(new int[]{nextNode, newDist});
                }
            }
        }

        return distances;
    }
}
