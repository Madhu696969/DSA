class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int s=requests[0];
        for(int i=1;i<requests.length;i++){
            s+=Math.abs(requests[i-1]-requests[i]);
        }
        return s;
    }
}