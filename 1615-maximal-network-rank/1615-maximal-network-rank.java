import java.util.*;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<Integer>[] lists = new ArrayList[n];
        
        for(int[] road : roads) {
            int a = road[0];
            int b = road[1];
            
            if(lists[a] == null)
                lists[a] = new ArrayList<>();
            if(lists[b] == null)
                lists[b] = new ArrayList<>();
            lists[a].add(b);
            lists[b].add(a);
        }
        
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int sizeI = lists[i] == null ? 0 : lists[i].size();
                int sizeJ = lists[j] == null ? 0 : lists[j].size();
                int rank = sizeI + sizeJ;
                
                if(lists[i] != null && lists[j] != null && lists[i].contains(j))
                    rank--;
                
                max = Math.max(rank, max);
            }
        }
        
        return max;
    }
}