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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> mp=new HashMap<>();
        HashMap<Integer,Integer> root=new HashMap<>();
        for(int[] d:descriptions){
            int r=d[0];
            int c=d[1];
            int l=d[2];
            if(!mp.containsKey(r)){
                mp.put(r,new TreeNode(r));
            }
            if(!mp.containsKey(c)){
                mp.put(c,new TreeNode(c));
            }
            if(l==1){
                mp.get(r).left=mp.get(c);
            }
            else{
                mp.get(r).right=mp.get(c);
            }
            if(root.getOrDefault(r,0)!=-1){
                root.put(r,1);
            }
            root.put(c,-1);
        }
        int rv=0;
        for(int k:root.keySet()){
            int val=root.get(k);
            if(val==1){
                rv=k;
                break;
            }
        }
        return mp.get(rv);
    }
}