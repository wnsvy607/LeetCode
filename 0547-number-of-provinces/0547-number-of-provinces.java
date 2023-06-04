class Solution {
    
    private int[][] graph;
    private boolean[] visited;
    int len;

    public int findCircleNum(int[][] isConnected) {
        var cnt = 0;
        len = isConnected.length;
        graph = isConnected;

        visited = new boolean[len];
        for(int i = 0; i < len ; i++) {
            if(visited[i])
                continue;
            
            DFS(i);
            cnt++;
        }


        return cnt;    
    }

    private void DFS(int node) {

        for(int i = 0; i < len; i++) {
            if(node == i)
                continue;

            if(graph[node][i] == 1 && !visited[i]) {
                visited[i] = true;
                DFS(i);
            }

        }
    }

}