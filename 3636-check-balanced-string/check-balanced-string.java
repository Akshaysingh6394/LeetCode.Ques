class Solution {
    public boolean isBalanced(String num) {
        int sumF = 0;
        int sumS = 0;
        for(int i=0;i<num.length();i++){
            if(i%2==0){
                sumF += num.charAt(i) - '0';
            }else{
                sumS += num.charAt(i) - '0';
            }
        }
        return sumF==sumS;
    }
}