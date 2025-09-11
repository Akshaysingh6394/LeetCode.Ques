class Solution {
    public String sortVowels(String s) {
        char[] vowels = {'A','E','I','O','U','a','e','i','o','u'};
        int[] stringCharCount = new int[128];
        char[] sChars = s.toCharArray();
        for(char ch : sChars){
            stringCharCount[ch]++;
        }
        boolean found = false;
        for(char ch : vowels){
            found |= stringCharCount[ch]>0;
        }
        if(!found) return s;
        
        boolean[] isVowels = new boolean[128];
        for(char ch : vowels){
            if(stringCharCount[ch]>0) isVowels[ch] = true;
        }
        int left = 0;
        for(char v : vowels){
            while(stringCharCount[v]>0){
                char ch = sChars[left];
                stringCharCount[v] -= isVowels[ch]?1:0; 
                sChars[left] = isVowels[ch]?v:ch; 
                left++;
            }
        }
        return new String(sChars);
    }
}