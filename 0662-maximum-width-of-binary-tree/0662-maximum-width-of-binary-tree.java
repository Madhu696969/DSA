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
    public int widthOfBinaryTree(TreeNode root) {
        int res=0;
        Deque<Pair> dq=new ArrayDeque<>();
        dq.addLast(new Pair(0,root));
        while(!dq.isEmpty()){
            int n=dq.size();
            Pair p1=dq.peekFirst();
            Pair p2=dq.peekLast();
            res=Math.max(res,p2.idx-p1.idx +1);
            while(n-- >0){
                Pair curP=dq.pollFirst();
                TreeNode cur=curP.node;
                int id=curP.idx;
                if(cur.left!=null){
                    dq.addLast(new Pair(2*id+1,cur.left));
                }
                if(cur.right!=null){
                    dq.addLast(new Pair(2*id+2,cur.right));
                }
            }
        }
        return res;
    }
}
class Pair{
    int idx;
    TreeNode node;
    Pair(int idx,TreeNode node){
        this.idx=idx;
        this.node=node;
    }
}