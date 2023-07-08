/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        return DFS(cloned, target.val);
        
    }
    
    TreeNode DFS(TreeNode node, int target) {
        if(node == null)
            return null;
        if(node.val == target)
            return node;
        
        TreeNode left = DFS(node.left, target);
        TreeNode right = DFS(node.right, target);
        
        if(left == null)
            return right;
        return left;
        
    }
}