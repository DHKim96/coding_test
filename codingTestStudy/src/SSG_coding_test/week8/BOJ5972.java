package SSG_coding_test.week8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ5972 {
    /*
    [BOJ]5972 : 택배 배송
     */

    private static List<List<Edge<Integer, Integer>>> graph;
    private static int N;
    private static int min = Integer.MAX_VALUE;
    private int[] distance;

    static class Edge<V, W> {
        private V v;
        private W weight;
        private boolean visited;

        public Edge(V v, W weight){
            this.v = v;
            this.weight = weight;
            this.visited = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int[] distance = new int[N];

        // 가중치 그래프
        graphInit(N);

        for (int i = 0; i < M; i++){
            stk = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            int weight = Integer.parseInt(stk.nextToken());

            addEdge(x, y, weight);
        }

        System.out.println(dijkstra(distance));
    }

    public static int dijkstra(int[] distance){

        PriorityQueue<Integer> pq = new PriorityQueue<>();


        for (Edge<Integer, Integer> edge : graph.get(node)){
            if (!edge.visited){
                edge.visited = true;
                min = Math.min(dfs(edge.v, sum + edge.weight), min);
                edge.visited = false;
            }
        }

        return min;
    }

    public static void addEdge(int x, int y, int weight){
        graph.get(x).add(new Edge<>(y, weight));
        graph.get(y).add(new Edge<>(x, weight));
    }

    public static void graphInit(int N){
        graph = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
    }


}
