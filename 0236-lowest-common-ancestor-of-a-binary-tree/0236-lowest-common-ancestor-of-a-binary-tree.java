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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solve(root,p,q);
    }
    private TreeNode solve(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return null;
        }
        if(root==p || root==q){
            return root;
        }
        TreeNode left=solve(root.left,p,q);
        TreeNode right=solve(root.right,p,q);
        if(left!=null && right!=null){
            return root;
        }
        if(left!=null) return left;
        return right;
    }
}