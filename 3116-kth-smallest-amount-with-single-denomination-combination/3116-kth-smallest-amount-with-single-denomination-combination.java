class Solution {
    int[] coins;
    long k;
    int n;
    public long findKthSmallest(int[] coins, int k) {
        this.coins=coins;
        this.k=k;
        this.n=coins.length;
        long l=1;
        long h=(long)coins[0]*k;
        for(int coin:coins){
            h=Math.min(h,(long)h*coin);
        }

        while(l<h){
            long mid=l+(h-l)/2;
            long c=count(mid);
            if(c>=k){
                h=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    private long count(long mid){
        return dfs(0,1,0,mid);
    }
    private long dfs(int idx,long lcm,int selected,long mid){
        if(idx==n){
            if(selected==0){
                return 0;
            }
            long val=mid/lcm;
            if(selected%2!=0){
                return val;
            }
            return -val;
        }
        long Ntake=dfs(idx+1,lcm,selected,mid);
        long NLcm=getLcm(lcm,coins[idx]);
        long take=dfs(idx+1,NLcm,selected+1,mid);
        return Ntake+take;
    }
    private long getLcm(long a,long b){
        return (a/gcd(a,b))*b;
    }
    private long gcd(long a,long b){
        while(b!=0){
            long t=a%b;
            a=b;
            b=t;
        }
        return a;
    }
}