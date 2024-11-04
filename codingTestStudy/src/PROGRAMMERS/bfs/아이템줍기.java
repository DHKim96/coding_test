package PROGRAMMERS.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class 아이템줍기 {
	   class Node {
	        int x, y, move;

	        public Node(int x, int y, int move) {
	            this.x = x;
	            this.y = y;
	            this.move = move;
	        }
	    }

	    public static int[] dx = {0, 0, -1, 1}; // 상, 하, 좌, 우
	    public static int[] dy = {1, -1, 0, 0};
	    
	    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
	        int answer = 0;
	        int[][] map = new int[101][101]; // 확장된 좌표 범위
	        boolean[][] visited = new boolean[101][101]; // 방문 배열
	        
	        draw(map, rectangle); // 테두리만 경로로 남기기

	        Queue<Node> q = new LinkedList<>();
	        q.add(new Node(characterX * 2, characterY * 2, 0));
	        visited[characterX * 2][characterY * 2] = true;

	        while (!q.isEmpty()) {
	            Node n = q.poll();
	            int currX = n.x, currY = n.y, currMove = n.move;

	            if (currX == itemX * 2 && currY == itemY * 2) {
	                answer = currMove / 2;
	                break;
	            }

	            for (int i = 0; i < 4; i++) {
	                int nextX = currX + dx[i];
	                int nextY = currY + dy[i];

	                if (canMove(nextX, nextY, map, visited)) {
	                    visited[nextX][nextY] = true;
	                    q.add(new Node(nextX, nextY, currMove + 1));
	                }
	            }
	        }
	        
	        return answer;
	    }

	  private void draw(int[][] map, int[][] rectangle) { // boolean 으로 표시했다가 못 풀었음!!!
	      // 외부, 테두리, 내부 의 3가지 상태가 필요했기에 int[][] 로 변환
	    for (int[] rec : rectangle) {
	        int x1 = rec[0] * 2, y1 = rec[1] * 2;
	        int x2 = rec[2] * 2, y2 = rec[3] * 2;

	        // 사각형 내부를 2로 설정
	        for (int i = x1 + 1; i < x2; i++) {
	            for (int j = y1 + 1; j < y2; j++) {
	                map[i][j] = 2; // 내부
	            }
	        }

	        // 테두리를 1로 설정 (이미 내부로 설정된 부분은 건너뜀)
	        for (int i = x1; i <= x2; i++) {
	            if (map[i][y1] != 2) map[i][y1] = 1; // 상단 테두리
	            if (map[i][y2] != 2) map[i][y2] = 1; // 하단 테두리
	        }

	        for (int j = y1; j <= y2; j++) {
	            if (map[x1][j] != 2) map[x1][j] = 1; // 좌측 테두리
	            if (map[x2][j] != 2) map[x2][j] = 1; // 우측 테두리
	        }
	    }
	}


	    private boolean canMove(int x, int y, int[][] map, boolean[][] visited) {
	        return x >= 1 && x <= 100 && y >= 1 && y <= 100 && map[x][y] == 1 && !visited[x][y];
	    }
}
