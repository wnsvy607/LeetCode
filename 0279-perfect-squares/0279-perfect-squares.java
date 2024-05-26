class Solution {

    int[] dp;

    public int numSquares(int n) {

        dp = new int[n + 1];
        dp[1] = 1;
        return get(n);
    }


    int get(int n) {
        if(n < 1)
            return 0;

        if(dp[n] != 0)
            return dp[n];
        
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int res = get(n - i * i) + 1;
            min = Math.min(res, min);
        }

        dp[n] = min;
        return min;
    }   

}