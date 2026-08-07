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
    public int maxAncestorDiff(TreeNode root) {
        dfs(root,root.val,root.val);
        return res;
    }
    private void dfs(TreeNode root,int min,int max){
        if(root==null){
            return;
        }
        res=Math.max(res,Math.abs(root.val-min));
        res=Math.max(res,Math.abs(root.val-max));
        int c_min=Math.min(min,root.val);
        int c_max=Math.max(max,root.val);
        dfs(root.left,c_min,c_max);
        dfs(root.right,c_min,c_max);
    }
}