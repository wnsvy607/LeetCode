class Solution {
    
    int[][] map;
    int[][] direction = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    int m, n;
    boolean[][] visited;
    
    public int findMaxFish(int[][] grid) {
        map = grid;
        m = grid.length;
        n = grid[0].length;
        int answer = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                visited = new boolean[m+1][n+1];
                answer = Math.max(answer, DFS(i, j));
            }
        }
        
        
        return answer;
        
    }
    
    int DFS(int y, int x) {
        if(y < 0 || x < 0 || y >= m || x >= n || map[y][x] == 0 || visited[y][x])
            return 0;
        int result = map[y][x];
        visited[y][x] = true;
        
        for(int i = 0; i < 4; i++) {
            result += DFS(y+direction[i][0], x+direction[i][1]);
        }
        
        return result;
    }
    
}