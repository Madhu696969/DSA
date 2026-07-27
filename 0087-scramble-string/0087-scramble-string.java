class Solution {
    HashMap<String,Boolean> mp=new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        return solve(s1,s2);
    }
    private boolean solve(String s1,String s2){
        if(s1.equals(s2)){
            return true;
        }
        if(s1.length()!=s2.length()){
            return false;
        }
        String key=s1+"-"+s2;
        if(mp.containsKey(key)){
            return mp.get(key);
        }
        boolean res=false;
        int n=s1.length();
        for(int i=1;i<n;i++){
            boolean swap=solve(s1.substring(0,i),s2.substring(n-i)) && solve(s1.substring(i),s2.substring(0,n-i));
            if(swap){
                res=true;
                break;
            }
            boolean notSwap=solve(s1.substring(0,i),s2.substring(0,i)) && solve(s1.substring(i),s2.substring(i));
            if(notSwap){
                res=true;
                break;
            }
        }
        mp.put(key,res);
        return res;
    }
}