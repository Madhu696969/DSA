class Solution {
    public long maxPairStrength(int[] nums) {
        long res=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                int a=nums[i];
                int b=nums[j];
                long g=gcd(Math.abs(a),Math.abs(b));
                g*=g;
                if(g==0) continue;
                res=Math.max(res,(1L*a*b)/g);
            }
        }
        return res;
    }
    private long gcd(int a,int b){
        while(b!=0){
            int t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
}