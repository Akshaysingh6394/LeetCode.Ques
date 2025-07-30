class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr == '(' || curr == '[' || curr == '{'){
                st.push(curr);
            }else {
                if(st.isEmpty()) return false;
                char top = st.pop();
                if((curr == ')' && top != '(') || (curr == ']' && top != '[') || (curr == '}' && top != '{') )
                return false;

            }
            
        }
        return st.isEmpty();
    }
}