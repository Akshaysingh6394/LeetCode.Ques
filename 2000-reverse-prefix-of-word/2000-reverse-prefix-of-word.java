class Solution {
       public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch)+1;
		StringBuffer rev = new StringBuffer(word.substring(0, idx));
		return rev.reverse()+word.substring(idx);
    }
}