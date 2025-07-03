class Solution {
    // Function to generate next version of the string
    private String getNewString(String s){
        StringBuilder sb = new StringBuilder(s);
        StringBuilder temp = new StringBuilder();

        // Generate transformed version (next character of each)
        for(char ch: s.toCharArray()){
            char nextChar = (char)(((ch - 'a' + 1) % 26) + 'a');
            temp.append(nextChar);
        }

        return sb.append(temp).toString();
    }

    public char kthCharacter(int k) {
        String s = "a";

        // Keep transforming until string length reaches or exceeds k
        while(s.length() < k){
            s = getNewString(s);
        }

        return s.charAt(k - 1);
    }
}