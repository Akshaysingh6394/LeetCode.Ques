class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        if(word1.length() != word2.length()) return false;
        for(int i=0;i<word1.length();i++){
            char ch = word1.charAt(i);
            freq1[ch-'a']++;
        }
        for(char ch : word2.toCharArray()){
            freq2[ch-'a']++;
        }
        
        for(int i=0;i<26;i++){
            if(Math.abs(freq1[i] - freq2[i]) > 3) return false;
        }
        return true;

    }
}