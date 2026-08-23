class Solution {
    public int longestSubarray(int[] nums, int k) {
        int max=0;
        for(int n:nums){
            max=Math.max(max,n);
        }
        int[] Primes=new int[max+1];
        for(int i=2;i<=max;i++){
            if(Primes[i]==0){
                Primes[i]=i;
                if((long)i*i<=max){
                    for(int j=i*i;j<=max;j+=i){
                        if(Primes[j]==0){
                            Primes[j]=i;
                        }
                    }
                }
            }
        }
        int res=0,l=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        int dist=0;
        for(int i=0;i<nums.length;i++){
            List<Integer> rls=getFactors(nums[i],Primes);
            for(int ele:rls){
                if(!mp.containsKey(ele)){
                    dist++;
                }
                mp.put(ele,mp.getOrDefault(ele,0)+1);
            }
            while(dist>k){
                List<Integer> lls=getFactors(nums[l],Primes);
                for(int ele:lls){
                    mp.put(ele,mp.get(ele)-1);
                    if(mp.get(ele)==0){
                        mp.remove(ele);
                        dist--;
                    }
                }
                l++;
            }
            res=Math.max(res,i-l+1);
        }
        return res;
    }
    private List<Integer> getFactors(int num,int[] Primes){
        List<Integer> res=new ArrayList<>();
        while(num>1){
            int val=Primes[num];
            res.add(val);
            while(num%val==0){
                num/=val;
            }
        }
        return res;
    }
}