class Solution {
    public String convert(String s, int numRows) {
        String[] res=new String[numRows];
        for(int i=0;i<numRows;i++){
            res[i]="";
        }
        int i=0;
        while(i<s.length()){
            for(int idx=0;idx<numRows && i<s.length();idx++){
                res[idx]+=s.charAt(i);
                i++;
            }
            for(int idx=numRows-2;idx>0 && i<s.length();idx--){
                res[idx]+=s.charAt(i++);
            }
        }
        String ans="";
        for(String s1:res){
            ans+=s1;
        }
        return ans;
    }
}