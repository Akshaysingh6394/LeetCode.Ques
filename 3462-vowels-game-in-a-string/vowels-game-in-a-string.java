class Solution {
    public boolean doesAliceWin(String s) {
        // A set for quick vowel lookups.
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        
        // Iterate through the string to find any vowel.
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                // If a vowel is found, Alice can always make a move (e.g., delete a single-vowel substring).
                // Thus, she wins.
                return true;
            }
        }
        
        // If the loop completes, no vowels were found.
        // Alice has no valid move, so she loses.
        return false;
    }
}