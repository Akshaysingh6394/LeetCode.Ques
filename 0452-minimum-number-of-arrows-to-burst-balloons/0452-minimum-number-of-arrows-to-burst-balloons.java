class Solution {
    public int findMinArrowShots(int[][] points) {
        
        int n = points.length;

        // Sort the points based on their end points
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int[] prev = points[0];
        int count = 1;

        for (int i = 1; i < n; i++) {
            int currStartPoint = points[i][0];
            int currEndPoint = points[i][1];

            int prevStartPoint = prev[0];
            int prevEndPoint = prev[1];

            if (currStartPoint > prevEndPoint) {
                count++;
                prev = points[i];
            } else {
                prev[0] = Math.max(prevStartPoint, currStartPoint);
                prev[1] = Math.min(currEndPoint, prevEndPoint);
            }
        }
        return count;
    }
}