class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
        int n = tri.size();
        int[][] dp = new int[n + 1][n + 1];
        
        int initialVal = tri.get(0).get(0);
        dp[0][0] = initialVal;
        
        for(int i = 1 ; i < n ; i++) {
            List<Integer> list = tri.get(i);
            dp[i][0] = dp[i-1][0] + list.get(0);
            dp[i][i] = dp[i-1][i-1] + list.get(i);
            for(int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + list.get(j);
             
            }
        }

        int answer = 2_000_001;
        for(int i = 0; i < n; i++) {
            answer = Math.min(answer, dp[n-1][i]);
        }
        
        return answer;
        
    }
}