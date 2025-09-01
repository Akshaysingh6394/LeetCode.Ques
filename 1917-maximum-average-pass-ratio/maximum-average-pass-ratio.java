class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;

        // Priority queue to act as a max-heap, storing pairs of {max-delta, index}
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // Initialize the priority queue with the delta values and indices
        for (int i = 0; i < n; i++) {
            double currentPR = (double) classes[i][0] / classes[i][1];
            double newPR = (double) (classes[i][0] + 1) / (classes[i][1] + 1);
            double delta = newPR - currentPR;
            pq.offer(new double[]{delta, i});
        }

        // Allocate extra students
        while (extraStudents-- > 0) {
            // Extract the class with the maximum delta
            double[] curr = pq.poll();
            int idx = (int) curr[1];

            // Update the class with an extra student
            classes[idx][0]++;
            classes[idx][1]++;

            // Recalculate the delta for this class
            double currentPR = (double) classes[idx][0] / classes[idx][1];
            double newPR = (double) (classes[idx][0] + 1) / (classes[idx][1] + 1);
            double delta = newPR - currentPR;

            // Push the updated delta and index back into the priority queue
            pq.offer(new double[]{delta, idx});
        }

        // Calculate the final average pass ratio
        double result = 0.0;
        for (int i = 0; i < n; i++) {
            result += (double) classes[i][0] / classes[i][1];
        }

        return result / n;
    }
}