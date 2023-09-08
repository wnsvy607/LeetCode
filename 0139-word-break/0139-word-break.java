class Solution {
    boolean[] dp;
    List<String> dict;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        dict = wordDict;
        dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for(int i = 1; i <= s.length(); i++) {
            dp[i] = canSegmented(s, i);
        }
        
        return dp[s.length()];
    }
    
    boolean canSegmented(String s, int end) {
        
        for(int i = 1; i <= end; i++) {
            if(!dp[i-1])
                continue;
            if(dict.contains(s.substring(i-1, end)))
                return true;
        }
        
        return false;
    }
}