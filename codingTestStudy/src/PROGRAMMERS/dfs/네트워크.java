package PROGRAMMERS.dfs;

class 네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                dfs(i, visited, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void dfs(int node, boolean[] visited, int[][] computers){
        visited[node] = true;
        
        for(int i = 0; i < computers[node].length; i++){
            if(computers[node][i] == 1){
                if(!visited[i]){
                    dfs(i, visited, computers);
                }
            }
        }
    }
}
