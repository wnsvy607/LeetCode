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
class Solution {
    
    int sum = 0;
    
    public int sumEvenGrandparent(TreeNode root) {
        DFS(root);
        return sum;
    }
    
    void DFS(TreeNode node) {
        if(node == null)
            return;
        
        if(node.val % 2 == 0) 
            sum += cal(node);
        
        DFS(node.left);
        DFS(node.right);
        
    }
    
    int cal(TreeNode node) {
        int result = 0;
        if(node.left != null) {
            if(node.left.left != null)
                result += node.left.left.val;
            if(node.left.right != null)
                result += node.left.right.val;               
        }
        if(node.right != null) {
            if(node.right.left != null)
                result += node.right.left.val;
            if(node.right.right != null)
                result += node.right.right.val;
        }
        
        return result;
        
    }
    
    
    
}