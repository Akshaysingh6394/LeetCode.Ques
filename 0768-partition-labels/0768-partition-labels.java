class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastOccurrence = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        int farthest = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            farthest = Math.max(farthest, lastOccurrence[s.charAt(i) - 'a']);
            if (i == farthest) {
                result.add(farthest - left + 1);
                left = i + 1;
            }
        }
        
        return result;
    }
}