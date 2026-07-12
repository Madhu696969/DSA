class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int[] sort=Arrays.stream(arr).distinct().sorted().toArray();
        for(int i=0;i<sort.length;i++){
            mp.put(sort[i],i+1);
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=mp.get(arr[i]);
        }
        return arr;
    }
}