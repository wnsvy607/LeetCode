class Solution {
    
    boolean[][] visited;
    int m, n;
    
    public int countServers(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int answer = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    visited[i][j] = true;
                    int servers = DFS(grid, i, j);
                    if(servers > 1)
                        answer += servers;
                }
            }
        }
        
        return answer;
    }
    
    int DFS(int[][] grid, int i, int j) {
        
        int result = 1;
        for(int k = 0; k < m; k++) {
            if(grid[k][j] == 1 && !visited[k][j] && k != i ) {
                visited[k][j] = true;
                result += DFS(grid, k, j);
            }
        }
        
        for(int k = 0; k < n; k++) {
            if(grid[i][k] == 1 && !visited[i][k] && k != j ) {
                visited[i][k] = true;
                result += DFS(grid, i, k);
            }
        }

        return result;
    }
}