class Solution {
    public boolean isStrictlyPalindromic(int n) {
                
        for(int base = 2; base < n - 1; base++) {
            if(!isPalindromic(base, n)) {
                return false;
            }
        }
        
        return true;
    }
    
    boolean isPalindromic(int base, int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(n % base);
            n /= base;
        }
        String result = sb.toString();
        int len = result.length();
        for(int i = 0; i < Math.floor(len / 2); i++) {
            if(result.charAt(i) != result.charAt(len - i - 1))
                return false;
        }
        
        return true;
    }
}