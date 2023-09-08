class Solution {
    
    boolean[][] dp;
    
    public String longestPalindrome(String s) {
        int len = s.length();
        dp = new boolean[len][len];
        String answer = "";
        
        for(int i = 0; i < len; i++) {
            for(int j = 0; i + j < len; j++) {
                String target = s.substring(j, j + i + 1);
                if(isPalindrome(target, j, j+i)) {
                    dp[j][j+i] = true;
                    answer = target;                  
                }
            }
        }
        
        return answer;
    }
    
    
    boolean isPalindrome(String tar, int start, int end) {
        if(start == end)
            return true;
        
        if(end - start == 1) {
            return tar.charAt(0) == tar.charAt(1);
        }
        
        
        if(tar.charAt(0) == tar.charAt(tar.length() - 1))
            return dp[start+1][end-1];
        
        return false;
    }
}