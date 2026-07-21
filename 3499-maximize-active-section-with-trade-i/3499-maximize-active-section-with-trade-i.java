class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int oC=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                oC++;
            }
        }
        int res=oC;
        s="1"+s+"1";
        int i=0,n=s.length();
        while(i<n && s.charAt(i)=='1'){
            i++;
        }
        int zc1=0;
        while(i<n && s.charAt(i)=='0'){
            zc1++;
            i++;
        }
        while(i<n){
            int oc=0;
            while(i<n && s.charAt(i)=='1'){
                i++;
                oc++;
            }
            if(oc==0) break;
            int zc2=0;
            while(i<n && s.charAt(i)=='0'){
                i++;
                zc2++;
            }
            if(zc2==0) break;
            res=Math.max(res,oC+zc1+zc2);
            zc1=zc2;
        }
        return res;
    }
}