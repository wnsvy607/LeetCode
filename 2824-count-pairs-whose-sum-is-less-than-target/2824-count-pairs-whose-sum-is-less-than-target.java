class Solution {
    public int countPairs(List<Integer> nums, int target) {
        nums.sort(Integer::compare);

        int n = nums.size();
        int s = 0;
        int e = n - 1;
        int cnt = 0;
        
        while(s < e) {
            int sum = nums.get(s) + nums.get(e);
            
            
            if(sum < target) {
                cnt += e - s;
                s++;
            } else {
                e--;
            }
        }
        
        
        return cnt;
    }
}