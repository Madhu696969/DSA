// 208. Implement Trie (Prefix Tree)

class TrieNode{
    public char val;
    public boolean isLast;
    public TrieNode[] children=new TrieNode[26];
    public TrieNode(){}
    public TrieNode(char c){
        TrieNode node=new TrieNode();
        node.val=c;
    }
}

class Trie {
    private TrieNode root;
    public Trie() {
        root=new TrieNode();
        root.val=' ';
    }
    public void insert(String word) {
        TrieNode ws=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            int idx=ch-'a';
            if(ws.children[idx]==null){
                ws.children[idx]=new TrieNode(ch);
            }
            ws=ws.children[idx];
        }
        ws.isLast=true;
    }
    
    public boolean search(String word) {
        TrieNode ws=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            int idx=ch-'a';
            if(ws.children[idx]==null){
                return false;
            }
            ws=ws.children[idx];
        }
        return ws.isLast;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode ws=root;
        int i=0;
        for(;i<prefix.length();i++){
            char ch=prefix.charAt(i);
            int idx=ch-'a';
            if(ws.children[idx]==null) return false;
            ws=ws.children[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */