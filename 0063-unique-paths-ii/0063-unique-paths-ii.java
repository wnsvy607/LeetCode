class Solution {
    
    private int[][] og; 
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        og = obstacleGrid;
        int m = og.length;
        int n = og[0].length;
        int[][] dp = new int[m+1][n+1];

        dp[1][1] = isObstcaleOn(1, 1) ? 0 : 1;
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(isObstcaleOn(i, j))
                    continue;
                dp[i][j] += isObstcaleOn(i, j-1) ? 0 : dp[i][j-1];    
                dp[i][j] += isObstcaleOn(i-1, j) ? 0 : dp[i-1][j];
            }
        }
        
        
        return dp[m][n];
    }
    
    private boolean isObstcaleOn(int i, int j) {
        return i < 1 || j < 1 || og[i-1][j-1] == 1;
    }
    
}