import java.util.*;

class Solution {
    boolean[] visited;
    int n;
    List<List<Integer>> answer;
    int[][] graph;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        answer = new ArrayList<>();
        n = graph.length;
        visited = new boolean[n];
    
        DFS(0, new ArrayList<>());
        
        return answer;
        
        
    }
    
    void DFS(int cur, List<Integer> list) {
        visited[cur] = true;
        list.add(cur);
        
        if(cur == n - 1) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            answer.add(temp);
        }
        
        for(int i = 0; i < graph[cur].length; i++) {
            DFS(graph[cur][i], list);
            visited[cur] = false;
        }
        list.remove(list.size() - 1);
    }
}
