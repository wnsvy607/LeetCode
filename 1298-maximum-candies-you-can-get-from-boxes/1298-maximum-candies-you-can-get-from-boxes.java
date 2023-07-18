import java.util.*;

class Solution {
    
    boolean[] opened;
    boolean[] keyOwned;
    boolean[] owned;
    int n;
    
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        n = status.length;
        opened = new boolean[n + 1];
        keyOwned = new boolean[n + 1];
        owned = new boolean[n + 1];
        
        int answer = 0;
        
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int box : initialBoxes) {
            owned[box] = true;
            q.add(box);
        }
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            if(!opened[cur] && (status[cur] == 1 || keyOwned[cur]) && owned[cur]) {
                answer += candies[cur];
                System.out.println("cur= " + cur + "|| number= " + candies[cur]);
                opened[cur] = true;
                
                for(int box : containedBoxes[cur]) {
                    owned[box] = true;
                    if(!opened[box])
                        q.add(box);
                }
                
                for(int key : keys[cur]) {
                    keyOwned[key] = true;
                    if(!opened[key] && owned[key] && keyOwned[key])
                        q.add(key);
                }
            }
        }
            
            
        return answer;
        
        
    }
}