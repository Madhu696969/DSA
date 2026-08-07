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
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        List<Integer> ls=new ArrayList<>();
        solve(root,ls,root.val);
        int res=0;
        for(int ele:ls){
            res+=ele;
        }
        return res;
    }
    private void solve(TreeNode root,List<Integer> ls,int cur){
        if(root.left==null && root.right==null){
            ls.add(cur);
            return;
        }
        if(root.left!=null){
            cur=cur*10+root.left.val;
            solve(root.left,ls,cur);
            cur/=10;
        }
        if(root.right!=null){
            cur=cur*10+root.right.val;
            solve(root.right,ls,cur);
            cur/=10;
        }
    }
}