class Solution {
    public boolean allZero(int frea[]){
        for(int num:frea){
            if(num != 0){
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int k = p.length();
        int frea[] = new int[26];
        for(int a=0;a<k;a++){
            char ch = p.charAt(a);
            frea[ch - 'a']++;
        }
        int i=0,j=0;
        ArrayList<Integer> list = new ArrayList<>();
        
        while(j<n){
            char chh = s.charAt(j);
            frea[chh-'a']--;
            if(j-i+1 == k){
                if(allZero(frea)){
                    list.add(i);
                }
                frea[s.charAt(i) -'a']++;
                i++;
            }
            j++;


        }
        return list;
    }
}