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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> ls1=new ArrayList<>();
        ArrayList<Integer> ls2=new ArrayList<>();

        solve(root1,ls1);
        solve(root2,ls2);

        return ls1.equals(ls2);
    }
    private void solve(TreeNode root,List<Integer> ls){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            ls.add(root.val);
            return;
        }
        solve(root.left,ls);
        solve(root.right,ls);
    }
}