
class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stk = new ArrayList<>();
        for (int x : nums) {
            stk.add(x);
            while (stk.size() > 1) {
                int last = stk.get(stk.size() - 1);
                int secondLast = stk.get(stk.size() - 2);
                int g = gcd(last, secondLast);
                if (g == 1) {
                    break;
                }
                // merge
                long lcm = (long) last * secondLast / g;
                // remove last
                stk.remove(stk.size() - 1);
                // replace secondLast with lcm
                stk.set(stk.size() - 1, (int) lcm);
            }
        }
        return stk;
    }
    
    private int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}