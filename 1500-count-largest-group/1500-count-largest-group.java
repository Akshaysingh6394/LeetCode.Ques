class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 1; i <= n; i++) {
            int sum = 0, x = i;
            while(x > 0){
                sum += x % 10;
                x /= 10;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            max = Math.max(max, map.get(sum));
        }
        int count = 0;
        for(int val : map.values()){
            if(val == max) count++;
        }
        return count;
    }
}