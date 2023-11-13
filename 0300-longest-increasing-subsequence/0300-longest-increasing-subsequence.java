class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        
        for(int val : nums) {
            int s = 0;
            int e = size;
            while(s != e) {
                int m = (s + e) / 2;        
                
                if(tails[m] < val)
                    s = m + 1;
                else
                    e = m;
            }
            
            tails[s] = val;
            if(s == size) size++;
            
        }
        
        return size;
    }
}