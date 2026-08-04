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
    int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int idx=0;
        int n=preorder.length;
        return solve(preorder,inorder,0,n-1);
    }
    private TreeNode solve(int[] preorder,int[] inorder,int st,int end){
        if(st>end){
            return null;
        }

        int rootV=preorder[idx++];
        int i=st;
        for(i=st;i<=end;i++){
            if(inorder[i]==rootV){
                break;
            }
        }
        TreeNode root=new TreeNode(rootV);
        root.left=solve(preorder,inorder,st,i-1);
        root.right=solve(preorder,inorder,i+1,end);
        return root;
    }
}