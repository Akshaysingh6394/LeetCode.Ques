class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int rem = 0;
        int n = baskets.length;

        for (int fruit : fruits) {
            boolean placed = false;

            for (int i = 0; i < n; i++) {
                if (fruit <= baskets[i]) {
                    baskets[i] = 0;
                    placed = true;
                    break;
                }
            }

            if (!placed) rem++;
        }

        return rem;
    }
}