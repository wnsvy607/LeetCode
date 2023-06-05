class Solution {
    
    private int[] root;
    private int[] rank;
    int n;

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        var cnt = n;
        root = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(isConnected[i][j] == 1) {
                    if(find(i) != find(j)) {
                        union(i, j);
                        cnt--;   
                    }
                }
            }
        }
        
        return cnt;    
    }

    int find(int x) {
        if(root[x] != x)
            while(root[x] != x) {
                x = root[x];
            }
        return x;
    }
    
    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX != rootY) {
            if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            } else if(rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            }
            else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }

    }
}