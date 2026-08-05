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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        boolean isNull=false;
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode val=q.poll();
            if(val==null){
                isNull=true;
            }
            else{
                if(isNull) return false;
                q.offer(val.left);
                q.offer(val.right);
            }
        }
        return true;
    }
}