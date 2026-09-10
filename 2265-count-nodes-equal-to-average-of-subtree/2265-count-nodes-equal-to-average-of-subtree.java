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
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return res;
    }
    private int[] solve(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        int[] l=solve(root.left);
        int[] r=solve(root.right);
        int s=l[0]+r[0]+root.val;
        int c=l[1]+r[1]+1;
        if((s/c)==root.val){
            res++;
        }
        return new int[]{s,c};
    }
}