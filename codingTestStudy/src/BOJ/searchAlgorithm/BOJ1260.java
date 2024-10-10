package BOJ.searchAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {
	/*
	 * 백준 no.1260 : DFS와 BFS
	 */
	// 정점 갯수
	static int N;
	// 간선 갯수
	static int M;
	// 방문 배열
	static boolean[] visited;
	// 인접 리스트로 구현한 그래프
	static List<ArrayList<Integer>> graph;
				
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 정점의 갯수
		N = Integer.parseInt(st.nextToken());
		// 간선의 갯수
		M = Integer.parseInt(st.nextToken());
		// 탐색 시작할 정점 번호
		int V = Integer.parseInt(st.nextToken());
		// 방문 배열
		visited = new boolean[N + 1]; // 1부터 사용
		
		// 그래프 만들기
		initGraph(N);
		
		// 입력 받기
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// 정점 연결
			putEdge(x, y);
		}
		
		for(List<Integer> list : graph) {
			Collections.sort(list);
		}
		
		StringBuilder sb = new StringBuilder();
		// 깊이 우선 탐색
		dfs(sb, V);
		
		visited = new boolean[N + 1]; // 초기화
		sb.append("\n");
		
		// 너비 우선 탐색
		bfs(sb, V);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	// 인접 리스트로 그래프 만드는 메소드
	public static void initGraph(int N) {
		// 인접리스트
		graph = new ArrayList<>();
		// 각 노드별 리스트를 만들어줌
		for(int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}
	}
	
	// 인접 리스트로 그래프 구현(간선 만들기)
	public static void putEdge(int x, int y) {
		graph.get(x).add(y);
		graph.get(y).add(x);
	}
	
	// 깊이 우선 탐색
	public static void dfs(StringBuilder sb, int node) {
		sb.append(node).append(" ");
		visited[node] = true;
		for(int child : graph.get(node)) {
			if(!visited[child]) {
				dfs(sb, child);				
			}
		}
	}
	
	// 너비 우선 탐색
	public static void bfs(StringBuilder sb, int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			sb.append(curr).append(" ");
			
			for(int child : graph.get(curr)) {
				if(!visited[child]) {
					queue.add(child);
					visited[child] = true;
				}
			}
		}
	}
}
