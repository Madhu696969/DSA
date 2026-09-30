class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res=new int[seq.length()];
        int dep=0;
        for(int i=0;i<seq.length();i++){
            if(seq.charAt(i)=='('){
                dep++;
                res[i]=dep%2;
            }
            else{
                res[i]=dep%2;
                dep--;
            }
        }
        return res;
    }
}