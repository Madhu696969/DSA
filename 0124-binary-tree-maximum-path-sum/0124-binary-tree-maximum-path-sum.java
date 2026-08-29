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
    int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        solve(root);
        return res;
    }
    private int solve(TreeNode root){
        if(root==null){
            return 0;
        }
        int ls=solve(root.left);
        int rs=solve(root.right);
        int tt=ls+rs+root.val;
        int atO=Math.max(ls,rs)+root.val;
        int jSr=root.val;
        res=Math.max(res,Math.max(tt,Math.max(atO,jSr)));
        return Math.max(atO,jSr);
    }
}