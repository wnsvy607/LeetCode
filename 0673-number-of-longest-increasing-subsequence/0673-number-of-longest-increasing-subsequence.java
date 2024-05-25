class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][2];
        
        int max = 1;
        
        for(int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    if(dp[j][0] + 1 > dp[i][0]) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = dp[j][1];
                        max = Math.max(max, dp[i][0]);
                    } else if(dp[j][0] + 1 == dp[i][0]) {
                        dp[i][1] += dp[j][1];
                    }
                }
                    
            }
        }

        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(dp[i][0] == max) count += dp[i][1];
        }
        
        return count;
    }
}