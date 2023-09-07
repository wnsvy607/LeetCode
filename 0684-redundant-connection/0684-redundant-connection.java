import java.util.*;

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n);
        
        for(int[] edge : edges) {
            if(!ds.union(edge[0], edge[1]))
                return edge;
        }
        
        throw new AssertionError();
    }
    
    class DisjointSet {
        int[] parent;
        //Uninon By Rank
        int[] rank;


        public DisjointSet(int size) {
            this.parent = new int[size + 1];
            for(int i = 1; i <= size; i++) {
                parent[i] = i;
            }
            this.rank = new int[size + 1];
        }
        
        private int find(int node) {
            if(parent[node] != node) parent[node] = find(parent[node]);
            return parent[node];
        }
        
        public boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            
            if(rootU == rootV)
                return false;
            else if(rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else if(rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
            
            return true;
        }
        
    }
}