package BOJ.algorithm.sort.Topological;

import java.io.*;
import java.util.*;

public class BOJ2252 {
    /*
    [BOJ]2252 : 줄 세우기
     */

    static List<Integer> solution(int N, int[][] edges){
        List<Integer> result = new ArrayList<>(); // 정렬된 결과 담을 리스트

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[N + 1]; // 진입차수 배열

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            inDegree[to]++; // 진입차수 증가
        }

        Queue<Integer> queue = new LinkedList<>(); // 진입차수 없는 정점 탐색 위한 큐

        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) { // 진입차수가 0인 정점을 큐에 추가
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            result.add(curr); // 결과 리스트에 정점 추가

            for (int neighbor : graph.get(curr)) {
                inDegree[neighbor]--; // 진입차수 차감
                if (inDegree[neighbor] == 0) { // 진입차수 0인 정점이라면 큐에 추가
                    queue.add(neighbor);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 키를 비교한 횟수

        int[][] edges = new int[M][2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
        }

        List<Integer> answer = solution(N, edges);

        StringBuilder sb = new StringBuilder();

        for (int num : answer) {
            sb.append(num).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
