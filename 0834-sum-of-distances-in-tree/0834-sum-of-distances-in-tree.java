class Solution {
    int N;
    int[] ans, count;
    List<List<Integer>> gr;

    void dfs(int node, int par) {
        for (int child : gr.get(node)) {
            if (child != par) {
                dfs(child, node);
                count[node] += count[child];
                ans[node] += ans[child] + count[child];
            }
        }
    }

    void dfs2(int node, int par) {
        for (int child : gr.get(node)) {
            if (child != par) {
                ans[child] = ans[node] - count[child] + (N - count[child]);
                dfs2(child, node);
            }
        }
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        N = n;
        gr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            gr.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            gr.get(u).add(v);
            gr.get(v).add(u);
        }

        ans = new int[n];
        count = new int[n];
        Arrays.fill(count, 1);

        dfs(0, -1);
        dfs2(0, -1);

        return ans;
    }
}