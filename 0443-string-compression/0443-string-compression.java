class Solution {
    public int compress(char[] chars) {
        int i=0;
        int index = 0;
        int n=chars.length;
        while(i<n){
            int count =0;
            char currchar = chars[i];
            while(i<n && chars[i]==currchar){
                count++;
                i++;
            }
            chars[index] = currchar;
            index++;
            if(count>1){
                String countstr = Integer.toString(count);
                for(char ch:countstr.toCharArray()){
                    chars[index]=ch;
                    index++;
                }
            }
        }
        return index;
    }
}