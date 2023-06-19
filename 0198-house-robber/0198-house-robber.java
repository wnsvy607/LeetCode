class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        
        dp[0] = nums[0];
        if(n == 1)
            return dp[0];
        
        dp[1] = nums[1];
        if(n == 2)
            return Math.max(dp[0], dp[1]);
        
        dp[2] = nums[2] + dp[0];
        if(n == 3)
            return Math.max(dp[2], dp[1]);
        
        
        for(int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
        }
        
        return Math.max(dp[n-1], dp[n-2]);
    }
}