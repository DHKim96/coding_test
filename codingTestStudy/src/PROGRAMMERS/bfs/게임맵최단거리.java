package PROGRAMMERS.bfs;

public class 게임맵최단거리 {
    private static int[] mRow = {-1, 1, 0, 0}; // 상 하 좌 우를 위한 값
    private static int[] mCol = {0, 0, -1, 1};

    private class Node{
        int row; // 행
        int col; // 열

        public Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public int solution(int[][] maps) {
        int[][] visited = new int[maps.length][maps[0].length]; // 방문 여부 확인 및 상대 진영까지의 거리 저장 목적

        bfs(visited, maps);

        int enemyLoca = visited[maps.length - 1][maps[0].length - 1];

        int answer = enemyLoca == 0 ? -1 : enemyLoca;

        return answer;
    }

    public void bfs(int[][] visited,int[][] maps){
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(0, 0));

        visited[0][0] = 1;

        while(!q.isEmpty()){
            Node curr = q.poll();

            for(int i = 0; i < 4; i++){ // 상하좌우 탐색 위한 반복문
                int nextRow = curr.row + mRow[i];
                int nextCol = curr.col + mCol[i];

                if(canMove(nextRow, nextCol, maps, visited)){
                    visited[nextRow][nextCol] = visited[curr.row][curr.col] + 1; // 방문 처리
                    q.add(new Node(nextRow, nextCol)); // 큐에 삽입
                }
            }
        }
    }

    public boolean canMove(int row, int col, int[][] maps, int[][] visited){
        return row >= 0 && row < maps.length && col >= 0 && col < maps[0].length
                && maps[row][col] == 1 && visited[row][col] == 0;
    }
}
