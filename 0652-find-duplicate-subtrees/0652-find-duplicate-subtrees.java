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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res=new ArrayList<>();
        HashMap<String,Integer> mp=new HashMap<>();
        dfs(root,mp,res);
        return res;
    }
    private String dfs(TreeNode root,Map<String,Integer> mp,List<TreeNode> res){
        if(root==null){
            return "";
        }
        String l=dfs(root.left,mp,res);
        String r=dfs(root.right,mp,res);

        String cur=root.val+"#"+l+"#"+r;
        if(mp.getOrDefault(cur,0)==1){
            res.add(root);
        }
        mp.put(cur,mp.getOrDefault(cur,0)+1);
        return cur;
    }
}