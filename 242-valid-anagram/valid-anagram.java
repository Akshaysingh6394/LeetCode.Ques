class Solution {
    public boolean isAnagram(String s, String t) {
        char arr[] = s.toCharArray();
        char arr1[] = t.toCharArray();
        Arrays.sort(arr);
        Arrays.sort(arr1);
        if(arr.length != arr1.length) return false;
        for(int i=0;i<arr.length;i++){
            if(arr[i] != arr1[i]){
                return false;
            }
        }
        return true;
    }
}