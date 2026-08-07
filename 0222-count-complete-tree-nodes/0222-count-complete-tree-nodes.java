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
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }

        int lH=getLHeight(root.left);
        int rH=getRHeight(root.right);

        if(lH==rH){
            return (1<<(lH+1))-1;
        }

        return 1+countNodes(root.left)+countNodes(root.right);
    }
    private int getLHeight(TreeNode root){
        TreeNode temp=root;
        int h=0;
        while(temp!=null){
            h++;
            temp=temp.left;
        }
        return h;
    }
    private int getRHeight(TreeNode root){
        TreeNode temp=root;
        int h=0;
        while(temp!=null){
            h++;
            temp=temp.right;
        }
        return h;
    }
}