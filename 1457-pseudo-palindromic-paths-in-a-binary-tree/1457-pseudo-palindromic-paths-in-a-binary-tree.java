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
    public int pseudoPalindromicPaths (TreeNode root) {
        solve(root,0);
        return res;
    }
    private void solve(TreeNode root,int c){
        if(root==null){
            return;
        }
        c=c^(1<<root.val);
        if(root.left==null && root.right==null){
            if((c & (c-1))==0){
                res++;
            }
        }
        solve(root.left,c);
        solve(root.right,c);
    }
}