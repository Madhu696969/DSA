class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        int start=toSec(startTime);
        int end=toSec(endTime);
        return end-start;
    }
    private int toSec(String s){
        int h=Integer.parseInt(s.substring(0,2));
        int m=Integer.parseInt(s.substring(3,5));
        int sec=Integer.parseInt(s.substring(6,8));
        return h*3600+m*60+sec;
    }
}