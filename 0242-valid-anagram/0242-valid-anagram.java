class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n!=m){
            return false;
        }
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        char[] chh = t.toCharArray();
        Arrays.sort(chh);
        for(int i=0;i<n;i++){
            if(ch[i]!=chh[i]){
                return false;
            }
        }
        return true;
    }
}