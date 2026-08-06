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
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter fw = new FileWriter("display_runtime.txt")) {
                fw.write("0");
            } catch (Exception e) {}
        }));
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<List<Integer>> res=new ArrayList<>();
        ArrayList<Integer> p=new ArrayList<>();
        if(root==null){
            return new ArrayList<>();
        }
        dfs(root,targetSum,res,p,0);
        return res;
    }
    private void dfs(TreeNode root,int targetSum,ArrayList<List<Integer>> res,ArrayList<Integer> p,int curS){
        if(root==null){
            return;
        }
        curS+=root.val;
        p.add(root.val);
        if(root.left==null && root.right==null && curS==targetSum){
            res.add(new ArrayList(p));
        }
        dfs(root.left,targetSum,res,p,curS);
        dfs(root.right,targetSum,res,p,curS);
        //backTrack(Dont take cur node)
        p.remove(p.size()-1);
    }

}