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
    HashMap<Integer,Integer> mp=new HashMap<>();
    int postIdx=0;
    public TreeNode buildTree(int[] inorder, int[] postorder){
        int n=inorder.length;
        for(int i=0;i<n;i++){
            mp.put(inorder[i],i);
        }
        postIdx=n-1;
        return solve(postorder,0,n-1);
    }
    private TreeNode solve(int[] postorder,int st,int end){
        if(st>end){
            return null;
        }
        int val=postorder[postIdx--];
        int next=mp.getOrDefault(val,0);
        TreeNode root=new TreeNode(val);
        root.right=solve(postorder,next+1,end);
        root.left=solve(postorder,st,next-1);
        return root;
    }
}