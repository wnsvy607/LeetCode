/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {
    
    Set<Integer> set = new TreeSet<>();
    
    public int minDiffInBST(TreeNode root) {
        
        DFS(root);
        int min = Integer.MAX_VALUE;
        int prev = -1;
        int cur = -1;
        for(Integer a : set) {
            cur = a;
            if(prev != -1 && Math.abs(cur - prev) < min)
                min = Math.abs(cur - prev);

            prev = a;
        }
        
        return min;
    }
    
    
    void DFS(TreeNode node) {
        if(node == null)
            return;
        
        set.add(node.val);
        
        DFS(node.left);        
        DFS(node.right);        
    }
}