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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> hs=new HashSet<>();
        for(int del:to_delete){
            hs.add(del);
        }
        List<TreeNode> res=new ArrayList<>();
        dfs(root,hs,res);
        if(!hs.contains(root.val)){
            res.add(root);
        }
        return res;
    }
    private TreeNode dfs(TreeNode root,Set<Integer> hs,List<TreeNode> res){
        if(root==null){
            return null;
        }
        root.left=dfs(root.left,hs,res);
        root.right=dfs(root.right,hs,res);
        if(hs.contains(root.val)){
            if(root.left!=null){
                res.add(root.left);
            }
            if(root.right!=null){
                res.add(root.right);
            }
            return null;
        }
        else{
            return root;
        }
        
    }
}