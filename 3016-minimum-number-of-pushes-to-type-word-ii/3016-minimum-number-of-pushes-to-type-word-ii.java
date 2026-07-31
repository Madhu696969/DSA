class Solution {
    public int minimumPushes(String word) {
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<word.length();i++){
            char r=word.charAt(i);
            mp.put(r,mp.getOrDefault(r,0)+1);
        }
        List<Map.Entry<Character,Integer>> p=new ArrayList<>(mp.entrySet());
        p.sort((a, b) -> b.getValue() - a.getValue());
        int idx=0;
        int res=0;
        for(Map.Entry<Character,Integer> pr:p){
            int freq=pr.getValue();
            int pu=(idx/8)+1;
            res+=pu*freq;
            idx++;
        }
        return res;
    }
}