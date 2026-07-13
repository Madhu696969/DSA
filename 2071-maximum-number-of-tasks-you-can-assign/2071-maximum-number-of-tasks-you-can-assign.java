class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int n=tasks.length;
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int st=0,end=n;
        int res=0;
        while(st<=end){
            int mid=st+(end-st)/2;

            if(isPossible(tasks,workers,pills,strength,mid)){
                res=mid;
                st=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return res;
    }
    private boolean isPossible(int[] tasks,int[] workers,int pills,int strength,int mid){
        Deque<Integer> dq=new ArrayDeque<>();
        int i=mid-1;
        int j=workers.length-1;
        while(i>=0){
            while(j>=workers.length-mid && j>=0 && workers[j]+strength>=tasks[i]){
                dq.offerFirst(workers[j]);
                j--;
            }
            if(dq.isEmpty()) return false;
            if(dq.peekLast()>=tasks[i]){
                dq.pollLast();
            }
            else{
                if(pills==0) return false;
                pills--;
                dq.pollFirst();
            }
            i--;
        }
        return true;
    }
}