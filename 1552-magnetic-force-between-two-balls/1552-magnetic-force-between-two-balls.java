class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int st=1,end=(position[position.length-1]-position[0])/(m-1);
        int res=1;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(CanPossible(position,mid,m)){
                res=mid;
                st=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return res;
    }
    private boolean CanPossible(int[] nums,int dis,int m){
        int cc=1,last=nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]-last>=dis){
                cc++;
                last=nums[i];
            }

            if(cc>=m) return true;
        }
        return false;
    }   
}