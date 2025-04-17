class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String str = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            int count  = 1;
            while(i<str.length()-1  && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(count).append(ch);
        }
        return sb.toString();
    }
}