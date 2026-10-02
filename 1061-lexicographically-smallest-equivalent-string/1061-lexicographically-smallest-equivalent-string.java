class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        HashMap<Character,List<Character>> mp=new HashMap<>();
        int n=s1.length();
        int m=baseStr.length();

        for(int i=0;i<n;i++){
            char u=s1.charAt(i);
            char v=s2.charAt(i);
            mp.putIfAbsent(u,new ArrayList<>());
            mp.putIfAbsent(v,new ArrayList<>());
            mp.get(u).add(v);
            mp.get(v).add(u);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<m;i++){
            int[] vis=new int[26];
            char ch=baseStr.charAt(i);
            sb.append(solve(mp,ch,vis));
        }
        return sb.toString();
    }

    private char solve(HashMap<Character,List<Character>> mp,char c_min,int[] vis){
        vis[c_min-'a']=1;
        char min=c_min;
        if(!mp.containsKey(c_min)){
            return min;
        }
        for(char ch:mp.get(c_min)){
            if(vis[ch-'a']==0){
                min=(char)Math.min(min,solve(mp,ch,vis));
            }
        }
        return min;
    }
}