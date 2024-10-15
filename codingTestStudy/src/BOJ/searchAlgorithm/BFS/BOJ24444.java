package BOJ.searchAlgorithm.BFS;

import java.io.*;
import java.util.*;

public class BOJ24444 {
    private static List<List<Integer>> graph; // 무방향 그래프를 인접 리스트로 표현
    private static int[] visited;             // 방문 순서를 저장할 배열
    private static int count = 0;             // 방문 순서 카운터
    private static Queue<Integer> queue;      // BFS 탐색을 위한 큐

    // 그래프 초기화 메서드
    public static void initGraph(int N) {
        graph = new ArrayList<>(N + 1); // 정점 번호 1부터 N까지 사용하므로 크기를 N + 1로 설정
        for (int i = 0; i <= N; i++) {  // 정점 번호 0은 사용하지 않음
            graph.add(new ArrayList<>()); // 각 정점에 빈 리스트를 추가하여 인접 리스트 초기화
        }
    }

    // 간선을 그래프에 추가하는 메서드
    public static void putEdge(int u, int v) {
        graph.get(u).add(v); // 정점 u에 인접한 정점 v를 추가
        graph.get(v).add(u); // 무방향 그래프이므로 정점 v에도 인접한 정점 u를 추가
    }

    // BFS 탐색 메서드
    public static void bfs(int R) {
        visited[R] = ++count; // 시작 정점 R을 방문 처리하고 방문 순서를 기록
        queue.add(R);         // 시작 정점을 큐에 삽입하여 BFS 시작

        while (!queue.isEmpty()) { // 큐가 빌 때까지 반복
            int node = queue.poll(); // 큐에서 현재 정점을 꺼냄
            // 현재 정점과 인접한 모든 정점에 대해
            for (int neighbor : graph.get(node)) {
                if (visited[neighbor] == 0) { // 인접 정점이 미방문 상태인 경우
                    visited[neighbor] = ++count; // 방문 순서를 기록
                    queue.add(neighbor);         // 큐에 인접 정점을 삽입
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 처리
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력 처리

        // 입력: 정점의 수 N, 간선의 수 M, 시작 정점 R
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 정점의 수
        int M = Integer.parseInt(input[1]); // 간선의 수
        int R = Integer.parseInt(input[2]); // 시작 정점 번호

        visited = new int[N + 1]; // 방문 순서를 저장하는 배열. 인덱스 0은 사용하지 않음
        queue = new LinkedList<>(); // BFS를 위한 큐 초기화
        
        initGraph(N); // 그래프 초기화

        // M개의 간선을 입력받아 그래프에 추가
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]); // 간선의 시작 정점 u
            int v = Integer.parseInt(input[1]); // 간선의 끝 정점 v
            putEdge(u, v); // 무방향 간선 (u, v) 추가
        }

        // 각 정점의 인접 리스트를 오름차순으로 정렬
        for (List<Integer> neighbors : graph) {
            Collections.sort(neighbors); // BFS에서 정점을 방문할 때 오름차순 방문을 위해 정렬
        }

        // BFS 수행
        bfs(R);

        // 각 정점의 방문 순서를 결과에 기록
        StringBuilder sb = new StringBuilder(); // 출력 최적화를 위한 StringBuilder 사용
        for (int node = 1; node <= N; node++) {
            sb.append(visited[node]).append("\n"); // 방문 순서를 각 정점에 대해 기록
        }

        // 결과 출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
