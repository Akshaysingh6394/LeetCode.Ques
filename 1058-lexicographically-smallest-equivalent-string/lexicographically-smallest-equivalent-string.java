class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
                int[] parent = new int[26];
        for (int i = 0; i < 26; i++) parent[i] = i;
        for (int i = 0; i < s1.length(); i++) {
            int a = s1.charAt(i) - 'a', b = s2.charAt(i) - 'a';
            int ra = find(parent, a), rb = find(parent, b);
            if (ra != rb) parent[Math.max(ra, rb)] = Math.min(ra, rb);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            sb.append((char)(find(parent, c - 'a') + 'a'));
        }
        return sb.toString();
    }
    private int find(int[] parent, int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}