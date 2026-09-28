class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> hs=new HashSet<>();
        HashSet<String> vis=new HashSet<>();

        for(String s:bank){
            hs.add(s);
        }
        Queue<String> q=new LinkedList<>();
        int lev=0;
        q.offer(startGene);
        vis.add(startGene);
        while(!q.isEmpty()){
            int n=q.size();

            while(n-- >0){
                String cur=q.poll();
                if(cur.equals(endGene)){
                    return lev;
                }
                for(char ch: new char[]{'A','C','G','T'}){
                    for(int i=0;i<cur.length();i++){
                        StringBuilder sb=new StringBuilder(cur);
                        sb.setCharAt(i,ch);
                        String n_s=sb.toString();
                        if(hs.contains(n_s) && !vis.contains(n_s)){
                            vis.add(n_s);
                            q.offer(n_s);
                        }
                    }
                }
            }
            lev++;
        }
        return -1;
    }
}