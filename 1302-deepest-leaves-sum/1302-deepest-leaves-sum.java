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
    
    int maxDepth = 0;
    int sum = 0;
    
    public int deepestLeavesSum(TreeNode root) {
        
        DFS(root, 0);
        
        return sum;
    }
    
    void DFS(TreeNode node, int depth) {
        // escape
        if(node.left == null && node.right == null) {
            if(maxDepth == depth)
                sum += node.val;
            else if(maxDepth < depth) {
                maxDepth = depth;
                sum = node.val;
            }
            return;
        }
        
        // perform
        if(node.left != null)
            DFS(node.left, depth + 1);
        if(node.right != null)
            DFS(node.right, depth + 1);
        
    }
    
}