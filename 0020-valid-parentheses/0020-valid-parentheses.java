class Solution {
    public boolean isValid(String s) {
        Stack<Character> p=new Stack<>();
        for(char r:s.toCharArray()){
            switch(r){
                case '(':
                case '{':
                case '[':p.push(r);
                break;
                case ')':if(p.isEmpty() || p.pop()!='('){
                    return false;
                }
                break;
                case '}':if(p.isEmpty() || p.pop()!='{'){
                    return false;
                }
                break;
                case ']':if(p.isEmpty() || p.pop()!='['){
                    return false;
                }
                break;
                default:return false;
            }
        }
        return p.isEmpty();

        

 
    }
}