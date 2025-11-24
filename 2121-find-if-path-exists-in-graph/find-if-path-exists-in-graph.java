class Solution {
    static class Edge{
        int src;
        int dest;
        Edge(int s,int d){
            this.src = s;
            this.dest=d;
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int e[]:edges){
            int u=e[0];
            int v = e[1];
            graph[u].add(new Edge(u,v));
            graph[v].add(new Edge(v,u));
        }
        boolean vis[] = new boolean[n];
        return hashPath(graph,vis,source,destination);



        
    }
    public boolean hashPath(ArrayList<Edge>graph[],boolean[] vis,int curr,int tar){
        if(curr == tar){
            return true;
        }
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                
                if(hashPath(graph,vis,e.dest,tar)){
                    return true;
                }
                
            }
        }
        return false;
    }
}