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
    
    TreeNode merged = new TreeNode();
    
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        if(root1 == null && root2 == null)
            return null;
        DFS(merged, root1, root2);
        
        return merged; 
    }
    
    void DFS(TreeNode root, TreeNode A, TreeNode B) {
        // 탈출
        if(root == null)
            return;
        
        // 수행
        int result;
        
        if(A != null && B != null)
            result = A.val + B.val;        
        else if(A != null)
            result = A.val;
        else
            result = B.val;
        
        root.val = result;
        
        if(left(A) != null || left(B) != null)
            root.left = new TreeNode();
        if(right(A) != null || right(B) != null)
            root.right = new TreeNode();
        
        DFS(root.left, left(A), left(B));
        DFS(root.right, right(A), right(B));
    }
    
    TreeNode left(TreeNode A) {
        if(A == null || A.left == null)
            return null;
        return A.left;
    }
    
    TreeNode right(TreeNode A) {
        if(A == null || A.right == null)
            return null;
        return A.right;
    }
    
}