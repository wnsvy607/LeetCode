class Solution {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len+1][amount+1];
        
        for(int i = 0; i <= len; i++) {
            dp[i][0] = 1;
        }
        
        for(int i = 1; i <= len ; i++) {
            
            for(int j = 1; j <= amount; j++) {
                // i-1번째 동전까지의 경우의 수를 불러온다
                dp[i][j] = dp[i-1][j];
                // i번째 동전을 사용할 수 있는 양이라면 이전 경우의 수(현재의 코인의 가짓수로 현재 총량 - 동전의 양을 만들 수 있는 경우의 수)
                // 를 더해준다.
                if(j >= coins[i-1])
                    dp[i][j] += dp[i][j-coins[i-1]];
            }
            
        }
        
        return dp[len][amount];
    }
}