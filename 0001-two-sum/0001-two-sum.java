import java.util.*;

class Solution {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();


        for(int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];

            if(map.containsKey(dif)) {
                int idx = map.get(dif).get(0);
                return new int[]{idx, i};
            }

            if(!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }



        return null;
    }


}