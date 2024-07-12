class Solution {
    public int maximumGain(String s, int x, int y) {
        int countA = 0;
        int countB = 0;
        int result = 0;
        int less = Math.min(x,y);
        
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            
            if(ch > 'b'){
                result += Math.min(countA , countB) * less;
                countA = 0;
                countB = 0;
            }else if(ch == 'a'){
                if(x < y && countB > 0){
                    countB--;
                    result += y;
                }else{
                    countA++;
                }
            }else{
                if(x > y && countA > 0){
                    countA--;
                    result+=x;
                }else{
                    countB++;
                }
            }
            
        }
        result+= Math.min(countA , countB)* less;
        
        return result;
    }
}