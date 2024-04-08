class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> wildCardStack = new Stack<>();

        Stack<Integer> openParenthesisStack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '('){
                openParenthesisStack.push(i);
            } else if(c == '*') {
                wildCardStack.push(i);
            } else {
                if(!openParenthesisStack.isEmpty()){
                    openParenthesisStack.pop();
                } else if(!wildCardStack.isEmpty()){
                    wildCardStack.pop();
                }else {
                    return false;
                }
            }
        }

        // if(openParenthesisStack.size() > wildCardStack.size()) return false;

        while(!openParenthesisStack.isEmpty() && !wildCardStack.isEmpty()){
            if(openParenthesisStack.peek() < wildCardStack.peek()){
                openParenthesisStack.pop();
                wildCardStack.pop();
            } else {
                return false;
            }
        }

        return openParenthesisStack.isEmpty();
    }
}