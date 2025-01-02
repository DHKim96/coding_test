package dataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {

    /**
     * Kahn 알고리즘 기반의 위상 정렬 메서드
     * @param numVertices 정점의 수
     * @param edges 간선 연결 정보
     * @return 위상 정렬된 결과
     */
    static List<Integer> solution(int numVertices, int[][] edges){
        // 인접 리스트 생성
        List<List<Integer>> graph = new ArrayList<>();
        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();
        // 정렬된 결과 담을 리스트
        List<Integer> result = new ArrayList<>();
        // 진입차수 배열
        int[] inDegree = new int[numVertices + 1];

        for (int i = 0; i <= numVertices; i++) {
            graph.add(new ArrayList<>());
        }

        // 진입차수 배열 생성
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            inDegree[to]++;
        }

        // 진입차수가 0인 노드부터 탐색 시작
        for (int i = 1; i <= numVertices; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            result.add(curr);

            for (int neighbor : graph.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // 정점 개수와 간선 정의
        int numVertices = 8;

        int[][] edges = {
                            {1, 3},
                            {1, 4},
                            {2, 3},
                            {2, 5},
                            {3, 6},
                            {4, 6},
                            {4, 7},
                            {5, 7},
                            {6, 8},
                            {7, 8},
                        };

        List<Integer> answer = solution(numVertices, edges);

        System.out.println(answer);
    }
}
