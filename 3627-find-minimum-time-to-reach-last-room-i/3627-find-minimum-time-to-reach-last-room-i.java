class Solution {
   static public int minTimeToReach(int[][] moveTime) {
        int r = moveTime.length, c = moveTime[0].length;
        int[][] minimumTime = new int[r][c];
        for (int[] is : minimumTime) {
            Arrays.fill(is, Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.steps - b.steps);
        pq.add(new Pair(-1, 0, 0));
        minimumTime[0][0] = 0;

        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            int i = top.i, j = top.j, nextStep = top.steps + 1;
            if (i + 1 < r) update(i + 1, j, pq, nextStep, moveTime, minimumTime);
            if (i - 1 >= 0) update(i - 1, j, pq, nextStep, moveTime, minimumTime);
            if (j - 1 >= 0) update(i, j - 1, pq, nextStep, moveTime, minimumTime);
            if (j + 1 < c)  update(i, j + 1, pq, nextStep, moveTime, minimumTime);
            if(minimumTime[r-1][c-1] != Integer.MAX_VALUE) return minimumTime[r-1][c-1] + 1;
        }
        return minimumTime[r-1][c-1] + 1;
    }

    static void update(int i, int j, PriorityQueue<Pair> pq, int nextStep, int[][] moveTime, int[][] minimumTime){
        if (nextStep < moveTime[i][j]) nextStep = moveTime[i][j];
        if (minimumTime[i][j] > nextStep) {
            pq.add(new Pair(nextStep, i, j));
            minimumTime[i][j] = nextStep;
        }
    }

}

class Pair {
    int steps = 0, i = -1, j = -1;

    public Pair(int steps, int i, int j) {
        this.steps = steps;
        this.i = i;
        this.j = j;
    }
}