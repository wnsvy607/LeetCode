class Solution {
    boolean[] dp;
    List<String> dict;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        dict = wordDict;
        dp = new boolean[s.length()];
        
        for(int i = 0; i < s.length(); i++) {
            dp[i] = canSegmented(s, i);
        }
        
        return dp[s.length() - 1];
    }
    
    boolean canSegmented(String s, int end) {
        
        for(int i = 0; i <= end; i++) {
            if(i != 0 && !dp[i-1])
                continue;
            if(dict.contains(s.substring(i, end + 1)))
                return i == 0 ? true : dp[i-1];
        }
        
        return false;
    }
}