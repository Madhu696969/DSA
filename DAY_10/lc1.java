// 2251. Number of Flowers in Full Bloom

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n=flowers.length;
        int[] st=new int[n];
        int[] end=new int[n];
        for(int i=0;i<n;i++){
            st[i]=flowers[i][0];
            end[i]=flowers[i][1];
        }
        Arrays.sort(st);
        Arrays.sort(end);
        int[] res=new int[people.length];
        for(int i=0;i<people.length;i++){
            int time=people[i];
            int up=BinarySearch(st,time)+1;
            int lw=BinarySearch(end,time-1)+1;
            res[i]=up-lw;
        }
        return res;
    }
    private int BinarySearch(int[] nums,int time){
        int st=0,end=nums.length-1;
        int res=-1;
        while(st<=end){
            int mid=st+(end-st)/2;

            if(nums[mid]<=time){
                res=mid;
                st=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return res;
    }

}