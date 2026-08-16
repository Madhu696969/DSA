class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int res=-1,gMin=Integer.MAX_VALUE;
        for(int i=0;i<drones.length;i++){
            int x1=drones[i][0];
            int y1=drones[i][1];
            int r=drones[i][2];

            int val=Math.abs(x1-target[0])+Math.abs(y1-target[1]);
            if(val<=r){
                if(val<gMin){
                    res=i;
                    gMin=val;
                }
            }
        }
        return res;
    }
}