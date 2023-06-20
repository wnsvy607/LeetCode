class Solution {
    
    
    
    public int deleteAndEarn(int[] nums) {
        int[] dp = new int[10_001];
        int[] cnt = new int[10_001];
        int maxNum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            cnt[num]++;
            maxNum = Math.max(maxNum, num);
        }
        
        dp[0] = 0;
        dp[1] = cnt[1];
        dp[2] = cnt[2] * 2;
        
        for (int i = 3; i < maxNum + 1; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3]) + (cnt[i] * i);
        }
        
        return Math.max(dp[maxNum], dp[maxNum - 1]);
    }
}