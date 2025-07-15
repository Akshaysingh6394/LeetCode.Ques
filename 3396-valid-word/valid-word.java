class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3 || !word.matches("[a-zA-Z0-9]+")) {
        return false;
    }
    String lower = word.toLowerCase();
    return lower.matches(".*[aeiou].*") && lower.matches(".*[b-df-hj-np-tv-z].*");

    }
}