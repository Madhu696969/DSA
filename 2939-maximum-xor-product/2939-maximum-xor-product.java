class Solution{
    public int maximumXorProduct(long a,long b,int n){
        for(long i=n-1;i>=0;i--){
            long bit=(1L<<i);
            if((a&bit)!=0 && (b&bit)!=0){
                continue;
            }
            else if((a&bit)!=0){
                if(a>b){
                    a^=bit;
                    b|=bit;
                }
                continue;
            }
            else if((b&bit)!=0){
                if(a<b){
                    a|=bit;
                    b^=bit;
                }
            }
            else{
                a|=bit;
                b|=bit;
            }
        }
        int mod=1_000_000_007;
        return (int)((a%mod)*(b%mod)%mod);
    }
}