class Solution {
    public int longestSubsequence(String s, int k) {
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') cnt++;
        }

        int num = 0, pos = 0, ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                int tmp = num | (1 << pos);
                if (tmp <= k) {
                    num = tmp;
                    pos++;
                } else {
                    break;
                }
            } else {
                pos++;
                cnt--;
            }

            ans = Math.max(ans, pos + cnt);
            if (pos >= 31) break;
        }

        return ans;
    }
}