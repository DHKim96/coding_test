package PROGRAMMERS.bruteForce;

import java.util.ArrayList;
import java.util.List;

public class 전력망을둘로나누기 {
    private static List<ArrayList<Integer>> network;
    private static boolean[] visited;

    public int solution(int n, int[][] wires) {
        int answer = n;

        initGraph(n, wires);

        for (int i = 0; i < wires.length; i++){
            visited = new boolean[n + 1];

            int x = wires[i][0];
            int y = wires[i][1];

            removeEdge(x, y);

            // 탐색 실시
            // 단절된 노드에서 탐색 실시 => 노드의 수가 정해져 있기 때문에 탐색할 필요없음
            // another = bfs(n, y);
            int count1 = dfs(x); // 노드의 갯수
            int count2 = n - count1; // 나머지 노드의 갯수

            answer = Math.min(answer, Math.abs(count1 - count2));

            // 다시 원복
            putEdge(x, y);
        }


        return answer;
    }

    public int dfs(int node){
        visited[node] = true;

        int count = 1;

        for (int neighbor : network.get(node)){
            if (!visited[neighbor]){
                visited[neighbor] = true;
                count += dfs(neighbor);
            }
        }

        return count;
    }

    // 전선 끊는 메서드
    public void removeEdge(int x, int y){
        network.get(x).remove((Integer)y);
        network.get(y).remove((Integer)x);
    }

    // 그래프 생성
    public void initGraph(int n, int[][] wires){
        network = new ArrayList<>(n + 1); // 1번 부터 사용하므로

        for (int i = 0; i <= n; i++){
            network.add(new ArrayList<Integer>());
        }

        for (int[] wire : wires){
            putEdge(wire[0], wire[1]);
        }
    }

    // 간선을 그래프에 추가
    public void putEdge(int x, int y){
        network.get(x).add(y);
        network.get(y).add(x);
    }



}
