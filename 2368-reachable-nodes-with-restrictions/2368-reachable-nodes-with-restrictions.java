class Solution {
    boolean[] visited;
    List[] nodes;
    
    
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        nodes = new List[n];
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            nodes[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            nodes[x].add(y);
            nodes[y].add(x);
        }
        
        for(int i = 0; i < restricted.length; i++) {
            int idx = restricted[i];
            visited[idx] = true;
        }
        
        visited[0] = true;
        return DFS(0);
    }
    
    int DFS(int node) {
        
        int total = 1;
        for(Object o : nodes[node]) {
            int next = (int) o;
            if(!visited[next]) {
                visited[next] = true;
                total += DFS(next);                
            }
        }
        return total;
    }
    
}