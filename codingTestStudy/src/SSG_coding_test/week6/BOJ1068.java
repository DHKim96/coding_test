package SSG_coding_test.week6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ1068 {
	/*
	 * [BOJ]1068 : 트리 주어진 트리에서 노드 하나를 지울 때, 남은 트리에서 리프 노드의 개수 구하기 노드 제거 == 해당 노드 및 그
	 * 자손 제거
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); // 트리의 노드의 개수

		List<List<Integer>> tree = new ArrayList<>();

		int count = 0;

		// 방문 배열
		boolean[] visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			tree.add(new ArrayList<>());
		}

		String[] input = br.readLine().split(" ");
		
		int root = -1;
		
		for (int i = 0; i < N; i++) {
			int parent = Integer.parseInt(input[i]);

			if (parent == -1) {
				root = i;
			} else {
				tree.get(parent).add(i);				
			}

		}
			
		
		for (List<Integer> nodes : tree) {
			System.out.println(nodes);
		}
		
		// 리프노드는 get 이후 자기보다 큰 숫자가 없는 경우

		int deleteNode = Integer.parseInt(br.readLine());
		
		if (deleteNode == root) {
			bw.write(0 + "");
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		
		 int parent = tree.get(deleteNode).get(0);
		 
		 
		 System.out.println(" 삭제 후");
		 
		for (List<Integer> nodes : tree) {
			System.out.println(nodes);
		}
		 
		
		// 순회
		Queue<Integer> q = new LinkedList<>();

		q.add(0);

		while (!q.isEmpty()) {
			int node1 = q.poll();
			visited[node1] = true;
			
			System.out.println("currnode =" + node1);
			System.out.println("tree.get(node1).isEmpty() = " +tree.get(node1).isEmpty());
			
			if (tree.get(node1).isEmpty()) {
				count++;
			} else {
				for (int neighborNode : tree.get(node1)) {
					if (!visited[neighborNode]) {
						q.add(neighborNode);
					}
				}
			}
		}

		bw.write(count + "");
		bw.flush();
		bw.close();
		br.close();
	}
}