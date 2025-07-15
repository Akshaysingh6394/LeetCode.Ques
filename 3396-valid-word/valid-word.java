class Solution {
    public boolean isValid(String word) {
        if(word.length() <3 ){
            return false;
        }
        boolean vowel = false;
        boolean consonent = false;
        for(char ch : word.toCharArray()){
            if(!Character.isLetterOrDigit(ch)){
                return false;
            }
            if(Character.isLetter(ch)){
                char lc = Character.toLowerCase(ch);
                if(lc=='a' || lc == 'e' || lc == 'i' || lc == 'o' || lc == 'u'){
                    vowel = true;
                }else{
                    consonent = true;
                }
            }

            
        }
        return vowel && consonent;

    }
}