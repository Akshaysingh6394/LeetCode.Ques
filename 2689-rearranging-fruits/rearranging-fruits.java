
class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> cnt = new HashMap<>();
        
        for (int c : basket1)
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        for (int c : basket2)
            cnt.put(c, cnt.getOrDefault(c, 0) - 1);

        List<Integer> last = new ArrayList<>();

        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            int v = e.getValue();
            if (v % 2 != 0) return -1;
            for (int i = 0; i < Math.abs(v) / 2; ++i)
                last.add(e.getKey());
        }

        if (last.isEmpty()) return 0;

        int minx = Math.min(Arrays.stream(basket1).min().getAsInt(),
                            Arrays.stream(basket2).min().getAsInt());

        int k = last.size() / 2;

        // Use quickselect to get first k smallest elements
        randomizedQuickSelect(last, 0, last.size() - 1, k);

        long res = 0;
        for (int i = 0; i < k; ++i)
            res += Math.min(last.get(i), minx * 2);

        return res;
    }

    public void randomizedQuickSelect(List<Integer> list, int left, int right, int k) {
        Random rand = new Random();
        while (left < right) {
            int pivotIndex = left + rand.nextInt(right - left + 1);
            Collections.swap(list, pivotIndex, right);
            int partitionIndex = partition(list, left, right);
            if (partitionIndex == k) return;
            else if (partitionIndex < k) left = partitionIndex + 1;
            else right = partitionIndex - 1;
        }
    }

    public int partition(List<Integer> list, int left, int right) {
        int pivot = list.get(right);
        int i = left;
        for (int j = left; j < right; j++) {
            if (list.get(j) < pivot) {
                Collections.swap(list, i, j);
                i++;
            }
        }
        Collections.swap(list, i, right);
        return i;
    }
}