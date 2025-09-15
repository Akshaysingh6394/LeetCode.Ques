class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> hm = new HashMap<>();
        if(s.length() != t.length()) return false;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            char cha = t.charAt(i);
            boolean containsKey = hm.containsKey(ch);
            if(hm.containsValue(cha) && !containsKey){
                return false;
            }
            if(containsKey && !hm.get(ch).equals(cha)){
                return false;
            }
            else{
                hm.put(ch,cha);
            }
        }
        return true;
    }
}