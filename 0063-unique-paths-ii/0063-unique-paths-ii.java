class Solution {
    
    int m, n;
    int[][] dp;
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        dp = new int[m][n];
        
        for(int i = 0; i < n; i++) {
            if(obstacleGrid[0][i] == 1)
                break;
            dp[0][i] = 1;            
        }
        
        for(int i = 1; i < m; i++) {
            if(obstacleGrid[i][0] == 0)
                dp[i][0] = dp[i - 1][0];
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1)
                    continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[m - 1][n - 1];
    }
}