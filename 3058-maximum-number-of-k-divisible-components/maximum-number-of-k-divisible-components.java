class Solution {
    int count = 0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        ArrayList<Integer> graph[] = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        boolean vis[] = new boolean[n];
        dfs(graph,0,-1,values,k);
        return count;
    }

    public int dfs(ArrayList<Integer> graph[],int curr,int parent,int[] values,int k) {
        int sum = values[curr];

        for(int i = 0; i < graph[curr].size(); i++) {
            int neigh = graph[curr].get(i);

            if(neigh != parent) {
                sum += dfs(graph,neigh,curr,values,k);
                sum %= k;
            }
        }

        sum %= k;
        if(sum == 0) {
            count++;
        }
        return sum;
    }
}