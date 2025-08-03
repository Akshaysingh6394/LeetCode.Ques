class Solution {
    public boolean isPalin(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
                i++;
                j--;
            
        }
        return true;
    }
    public String longestPalindrome(String s) {
        String str = "";
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                String subStr = s.substring(i,j);
                if(isPalin(subStr)){
                    if(str.length()<subStr.length()){
                    str = subStr;
                }
                }
                
            }
        }
        return str;
    }
}