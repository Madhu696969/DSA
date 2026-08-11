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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int idx=0;
        while(!q.isEmpty()){
            int n=q.size();
            int prev = (idx%2==0)?Integer.MIN_VALUE:Integer.MAX_VALUE;
            while(n-- >0){
                TreeNode cur=q.poll();
                int val=cur.val;
                if(idx%2==0){
                    if(val%2==0){
                        return false;
                    }
                    if(prev>=val){
                        return false;
                    }
                }
                else{
                    if(val%2!=0){
                        return false;
                    }
                    if(prev<=val){
                        return false;
                    }
                }
                    prev=val;
                if(cur.left!=null){
                    q.offer(cur.left);
                }
                if(cur.right!=null){
                    q.offer(cur.right);
                }
            }
            idx++;
        }
        return true;
    }
}