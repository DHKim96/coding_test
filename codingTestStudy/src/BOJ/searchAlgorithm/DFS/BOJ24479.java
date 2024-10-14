package BOJ.searchAlgorithm.DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ24479 {
    private static int[] visited; // 방문 배열
    private static List<ArrayList<Integer>> graph; // 무방향 그래프
    private static int count; // 방문 순서를 저장하는 전역 변수

    // 양방향 간선 연결
    public static void putEdge(int a, int b) {
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    // 인접 리스트로 무방향 그래프 생성
    public static void initGraph(int N) {
        graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
    }

    // 깊이 우선 탐색 실시
    public static void dfs(int node) {
        visited[node] = count++;
        for (int neighbor : graph.get(node)) {
            if (visited[neighbor] == 0) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 간선의 수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점

        initGraph(N); // 그래프 생성
        visited = new int[N + 1]; // 방문 배열 생성 (0번 인덱스 사용하지 않음)
        count = 1; // 방문 순서 초기화

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            putEdge(u, v); // 간선 연결
        }

        // 각 정점을 오름차순으로 정렬
        for (ArrayList<Integer> list : graph) {
            Collections.sort(list);
        }

        // 깊이 우선 탐색 실시
        dfs(R);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
