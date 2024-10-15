package BOJ.searchAlgorithm.BFS;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ24444 {
    /*
        BOJ NO.24444 : 알고리즘 수업 - 너비 우선 탐색 1
            => BFS(Breadth First Search) 구현해보기
     */

    private static List<ArrayList<Integer>> graph; // 무방향 그래프
    private static boolean[] visited;
    private static StringBuilder sb;
    private static Queue<Integer> queue;

    // 인접 리스트를 통한 무방향 그래프 생성하는 메소드
    public static void initGraph(int N){
        for(int i=0; i<N; i++){
            graph.add(new ArrayList<Integer>());
        }
    }

    // 간선 연결하는 메소드
    public static void putEdge(int x, int y){
        graph.get(x).add(y);
        graph.get(y).add(x);
    }

    // 너비 우선 탐색
    public static void bfs(int node){

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 정점의 수
        int M = Integer.parseInt(input[1]); // 간선의 수
        int R = Integer.parseInt(input[2]); // 시작 정점

        graph = new LinkedList<>();
        visited = new boolean[N + 1]; // 인덱스 0은 사용하지 않음

        initGraph(N); // 무방향 그래프 생성
        
        // 간선 연결
        for(int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            putEdge(x, y);
        }

        bfs(R);



    }
}
