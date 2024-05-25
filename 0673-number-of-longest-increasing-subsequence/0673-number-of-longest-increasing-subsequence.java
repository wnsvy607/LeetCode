class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] cnt = new int[nums.length];
        
        int max = 1;
        
        for(int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    if(dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                        max = Math.max(max, dp[i]);
                    } else if(dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
                    
            }
        }

        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(dp[i] == max) count += cnt[i];
        }
        
        return count;
    }
}