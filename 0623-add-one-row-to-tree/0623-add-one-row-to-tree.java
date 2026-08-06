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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newNode=new TreeNode(val);
            newNode.left=root;
            return newNode;
        }
        int dep=1;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                TreeNode cur=q.poll();
                if(dep+1==depth){
                    TreeNode left=cur.left;
                    TreeNode right=cur.right;
                    TreeNode nL=new TreeNode(val);
                    TreeNode nR=new TreeNode(val);
                    cur.left=nL;
                    cur.right=nR;
                    nL.left=left;
                    nR.right=right;
                }
                else{
                    if(cur.left!=null) q.offer(cur.left);
                    if(cur.right!=null) q.offer(cur.right);
                }
            }
            if(dep+1==depth){
                break;
            }
            dep++;
        }
        return root;
    }
}