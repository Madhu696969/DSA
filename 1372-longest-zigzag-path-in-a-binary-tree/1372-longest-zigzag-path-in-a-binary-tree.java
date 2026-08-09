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
    int res=0;
    public int longestZigZag(TreeNode root) {
        solve(root,0,0);
        solve(root,0,1);
        return res;
    }
    private void solve(TreeNode root,int steps,int cur){
        if(root==null){
            return;
        }
        res=Math.max(res,steps);
        if(cur==0){
            solve(root.left,steps+1,1);
            solve(root.right,1,0);
        }
        else{
            solve(root.right,steps+1,0);
            solve(root.left,1,1);
        }
    }
}