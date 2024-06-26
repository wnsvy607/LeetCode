class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        
        int max = 1;
        for(int i = 0; i < len; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(max, dp[i]);
                }
                
            }
        }
        return max;
    }
}