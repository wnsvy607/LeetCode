class Solution {
    int answer, n;
    
    int[] dy = {0, 0, -1, 1};
    int[] dx = {-1, 1, 0, 0};
    int[][] map;
    boolean[][] visited;
    
    public int swimInWater(int[][] grid) {
        n = grid.length;
        map = grid;
        int start = grid[0][0];
        int end = n * n - 1;
        int mid = 0;
        
        while(start <= end) {
            mid = (int) Math.floor((start + end) / 2);
            visited = new boolean[n][n];
            visited[0][0] = true;
            
            if(DFS(mid, 0, 0)) {
                answer = mid;
                end = mid - 1;
            } 
             else 
                start = mid + 1;
        }
        
        return answer;
    }
    
    boolean DFS(int depth, int y, int x) {
        
        boolean isAbleToGet = false;
        
        for(int i = 0; i < 4; i++) {

            if(isAbleToGet)
                return true;
            
            int cy = dy[i] + y;
            int cx = dx[i] + x;
            
            if(cy < 0 || cx < 0 || cy >= n || cx >= n)
                continue;
            if(visited[cy][cx] || map[cy][cx] > depth)
                continue;
            
            if(cy == n - 1 && cx == n - 1)
                return true;

            visited[cy][cx] = true;
            isAbleToGet = DFS(depth, cy, cx);
        }
        
        return isAbleToGet;
    }
}