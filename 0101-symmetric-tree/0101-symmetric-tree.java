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

    // Can be Solved Using BFS as Well Use 2-pointer and to compare
    public boolean isSymmetric(TreeNode root) {
        return solve(root.left,root.right);
    }
    private boolean solve(TreeNode node1,TreeNode node2){
        if(node1==null && node2==null){
            return true;
        }
        if(node1==null || node2==null){
            return false;
        }
        return node1.val==node2.val && solve(node1.left,node2.right) && solve(node1.right,node2.left);
    }
}