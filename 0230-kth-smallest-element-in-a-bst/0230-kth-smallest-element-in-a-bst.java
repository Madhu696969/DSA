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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        if(root==null){
            return 0;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int s=q.size();
            while(s-- >0){
                TreeNode cur=q.poll();
                if(pq.size()<k){
                    pq.add(cur.val);
                }
                else{
                    if(pq.peek()>cur.val){
                        pq.poll();
                        pq.add(cur.val);
                    }
                }
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
        }
        return pq.poll();
    }
}