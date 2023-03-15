class Solution {
       public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(computers, i, visited);
                    answer += 1;
                }
            }
            return answer;
        }




    private boolean[] dfs(int[][] computers, int i, boolean[] visited) {
        visited[i] = true;

        for(int j = 0; j < computers.length; j++){
            if(i != j && computers[i][j] == 1 && !visited[j]){
                dfs(computers, j, visited);
            }
        }

        return visited;
    }

}
