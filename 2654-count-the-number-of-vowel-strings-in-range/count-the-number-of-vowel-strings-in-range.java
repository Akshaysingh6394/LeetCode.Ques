class Solution {
    public boolean checKV(String str){
        int st = 0, end = str.length()-1;
        if(str.charAt(st) == 'a' || str.charAt(st)=='e' || str.charAt(st)=='i' || str.charAt(st)=='o' || str.charAt(st)=='u'){
            if(str.charAt(end)=='a' || str.charAt(end)=='e' || str.charAt(end)=='i' ||str.charAt(end)=='o' || str.charAt(end)=='u'){
                return true;
            }
            
            
        }
        return false;
    }
    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for(int i=left;i<=right;i++){
            if(checKV(words[i])){
                count++;
            }
        }
        return count;
    }
}