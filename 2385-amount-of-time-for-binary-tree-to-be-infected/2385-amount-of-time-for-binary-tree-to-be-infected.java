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
    HashMap<Integer,TreeNode> mp=new HashMap<>();
    TreeNode st;
    public int amountOfTime(TreeNode root, int start) {
        if(root==null){
            return 0;
        }
        InOrder(root,start);
        Queue<TreeNode> q=new LinkedList<>();
        HashSet<Integer> hs=new HashSet<>(); 
        q.offer(st);
        hs.add(st.val);
        int res=0;
        while(!q.isEmpty()){
            int n=q.size();
            while(n-- >0){
                TreeNode cur=q.poll();
                if(cur.left!=null && !hs.contains(cur.left.val)){
                    hs.add(cur.left.val);
                    q.offer(cur.left);
                }
                if(cur.right!=null && !hs.contains(cur.right.val)){
                    q.offer(cur.right);
                    hs.add(cur.right.val);
                }
                if(mp.get(cur.val)!=null && !hs.contains(mp.get(cur.val).val)){
                    q.offer(mp.get(cur.val));
                    hs.add(mp.get(cur.val).val);
                }
            }
            if(!q.isEmpty())
                res++;
        }
        return res;

    }
    private void InOrder(TreeNode root,int start){
        if(root==null){
            return;
        }
        if(root.val==start){
            st=root;
        }
        if(root.left!=null){
            mp.put(root.left.val,root);
        }
        InOrder(root.left,start);
        if(root.right!=null){
            mp.put(root.right.val,root);
        }
        InOrder(root.right,start);
    }
}