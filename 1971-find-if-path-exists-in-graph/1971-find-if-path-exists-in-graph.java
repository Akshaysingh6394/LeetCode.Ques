class Solution {
    boolean[] vis;
    List<List<Integer>> gr;

    void dfs(int node) {
        if (vis[node]) return;
        vis[node] = true;

        for (int child : gr.get(node)) {
            if (!vis[child])
                dfs(child);
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        vis = new boolean[n];
        gr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            gr.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            gr.get(u).add(v);
            gr.get(v).add(u);
        }

        dfs(source);
        return vis[destination];
    }
}