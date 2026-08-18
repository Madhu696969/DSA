class Solution {
    public List<List<String>> partition(String s) {
        ArrayList<List<String>> res=new ArrayList<>();
        ArrayList<String> p=new ArrayList<>();
        BackTrack(s,0,p,res);
        return res;
    }
    public void BackTrack(String s,int idx,ArrayList<String> p,ArrayList<List<String>> res){
        if(idx==s.length()){
            res.add(new ArrayList<>(p));
        }
        for(int i=idx;i<s.length();i++){
            if(isPalin(s,idx,i)){
                p.add(s.substring(idx,i+1));
                BackTrack(s,i+1,p,res);
                p.remove(p.size()-1);
            }
        }
    }
    public boolean isPalin(String p,int i,int e){
        while(i<e){
            if(p.charAt(i)!=p.charAt(e)){
                return false;
            }
            i++;
            e--;
        }
        return true;
    }
}