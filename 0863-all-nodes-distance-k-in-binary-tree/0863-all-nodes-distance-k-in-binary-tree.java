/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode,TreeNode> mp=new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root==null){
            return null;
        }
        inOrder(root);
        List<Integer> res=new ArrayList<>();
        solve(root,target,k,res);
        return res;
    }
    private void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left!=null){
           mp.put(root.left,root);
        }
        inOrder(root.left);
        if(root.right!=null){
            mp.put(root.right,root);
        }
        inOrder(root.right);
    }
    private void solve(TreeNode root,TreeNode tar,int k,List<Integer> res){
        Queue<TreeNode> q=new LinkedList<>();
        Set<Integer> vis=new HashSet<>();
        q.offer(tar);
        vis.add(tar.val);
        while(!q.isEmpty()){
            int n=q.size();

            if(k==0){
                break;
            }

            for(int i=0;i<n;i++){
                TreeNode cur=q.poll();

                if(cur.left!=null && !vis.contains(cur.left.val)){
                    q.offer(cur.left);
                    vis.add(cur.left.val);
                }
                if(cur.right!=null && !vis.contains(cur.right.val)){
                    q.offer(cur.right);
                    vis.add(cur.right.val);
                }
                if(mp.containsKey(cur) && !vis.contains(mp.getOrDefault(cur,null).val)){
                    q.offer(mp.get(cur));
                    vis.add(mp.get(cur).val);
                }
            }
            k--;
        }

        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            res.add(cur.val);
        }
    }

}