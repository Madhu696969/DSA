class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> mp=new HashMap<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0;i<s.length();i++){
            char t=s.charAt(i);
            mp.put(t,mp.getOrDefault(t,0)+1);
        }
        for(Map.Entry<Character,Integer> ent:mp.entrySet()){
            pq.offer(new int[]{ent.getKey(),ent.getValue()});
        }
        StringBuilder res=new StringBuilder();
        int[] prev = new int[]{'#', 0};
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            res.append((char)cur[0]);
            if(prev[1]>0){
                pq.offer(prev);
            }
            cur[1]--;
            prev=cur;
        }
        if(res.length()!=s.length()){
            return "";
        }
        return res.toString();
    }
}