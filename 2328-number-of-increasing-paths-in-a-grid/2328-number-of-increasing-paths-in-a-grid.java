class Solution {
    
    // 모듈러 연산을 진행할 수 10^9 + 7
    long mod = (long)Math.pow(10,9)+7;
    
    public int countPaths(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        
        // 각 grid에서 갈 수 있는 path의 개수를 저장한 dp 배열
        long[][] dp = new long[m][n];
        
        //DFS를 통해 dp를 계산 
        for (int i = 0; i<grid.length; i++) {
            for (int j = 0; j<grid[0].length; j++) {
                if (dp[i][j]==0) {
                    dfs(grid, dp, i, j, m, n, -1);
                }
            }
        }
        
        //합계 구하기
        long sum = 0;
        for (long[] d: dp) {
            for (long i: d) {
                sum= (sum+i)%mod;
            }
        } 
        
        return (int)sum;
    }
    
    public long dfs(int[][] grid, long[][] dp, int i, int j, int m, int n, int prevValue) {
        //유효한 값이 아니거나 이전 노드의 값보다 작거나 같으면 진행할 수 없다.
        if (i<0 || j<0 || i>=m || j>=n || prevValue>=grid[i][j]) 
            return 0;
        
        // 기존에 계산된 값이 있다면 계산된 값을 반환한다.
        if (dp[i][j]!=0)
            return dp[i][j];
        
        prevValue = grid[i][j];
        
        //상하좌우를 재귀적으로 계산한다.
        long left = dfs(grid, dp, i, j-1, m, n, prevValue)%mod;
        long bottom = dfs(grid, dp, i+1, j, m, n, prevValue)%mod;
        long right = dfs(grid, dp, i, j+1, m, n, prevValue)%mod;
        long top = dfs(grid, dp, i-1, j, m, n, prevValue)%mod;
        
        // 계산한 결과에 1(경로가 해당 노드 하나만 존재하는 경우)을 더한다.
        dp[i][j] = (1+left+top+bottom+right)%mod;
        return dp[i][j];
    }
}