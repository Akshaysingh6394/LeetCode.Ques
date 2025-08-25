import java.util.*;

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) return new int[0];

        int r = mat.length;
        int c = mat[0].length;

        // Step 1: Group elements by (i + j)
        Map<Integer, List<Integer>> di = new HashMap<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int sum = i + j;
                di.putIfAbsent(sum, new ArrayList<>());
                di.get(sum).add(mat[i][j]);
            }
        }

        // Step 2: Build result in zig-zag order
        List<Integer> res = new ArrayList<>();
        for (int s = 0; s < r + c - 1; s++) {
            List<Integer> vals = di.get(s);
            if (s % 2 == 0) {
                Collections.reverse(vals);
            }
            res.addAll(vals);
        }

        // Convert List<Integer> to int[]
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}