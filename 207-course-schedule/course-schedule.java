class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v= prerequisites[i][1];
            list.get(u).add(v);
        }
        boolean vis[]= new boolean[numCourses];
        boolean rec[] = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(dfs(list,i,vis,rec)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> list,int curr,boolean vis[] , boolean rec[]){
        vis[curr] = true;
        rec[curr] = true;
        for(int dest:list.get(curr)){
            if(rec[dest]) return true;
            if(!vis[dest]){
                if(dfs(list,dest,vis,rec)){
                    return true;
                }
            }
        }
        rec[curr] = false;
        return false;
    }
}