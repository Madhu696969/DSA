class Solution {
    public int[] sortByBits(int[] arr) {
        for(int i=0;i<arr.length;i++){
            arr[i]=CountBit(arr[i])*100000+arr[i];
        }
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            arr[i]=arr[i]%100000;
        }
        return arr;
    }
    public int CountBit(int n){
        return Integer.bitCount(n);
    }
}