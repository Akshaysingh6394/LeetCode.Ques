class Solution {
    int counter=0;
    public void dfs(int node, int parent, int[]inTime, int[]outTime, int[]xorSubset, int nums[], List<List<Integer>> adj){
        xorSubset[node]=nums[node];
        inTime[node]=counter;
        counter++;
        for(int neighbor: adj.get(node)){
            if(neighbor!=parent){
                dfs(neighbor, node, inTime, outTime, xorSubset, nums, adj);
                xorSubset[node]^=xorSubset[neighbor];
            }
        }
        outTime[node]=counter;
        counter++;
    }
    public boolean isAncestor(int u, int v, int[]inTime, int[]outTime){
        return ((inTime[u]<=inTime[v])&& (outTime[u]>=outTime[v]));
    }
    public int minimumScore(int[] nums, int[][] edges) {
        List<List<Integer>> adj  = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int[]pair: edges){
            adj.get(pair[0]).add(pair[1]);
            adj.get(pair[1]).add(pair[0]);
        }
        int[]inTime=new int[nums.length];
        int[]outTime=new int[nums.length];
        int[]xorSubset=new int[nums.length];
        dfs(0, -1, inTime, outTime, xorSubset, nums, adj);
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int xor1;
                int xor2;
                int xor3;
                if(isAncestor(i, j, inTime, outTime)){
                    xor2=xorSubset[j];
                    xor1= xorSubset[i]^xorSubset[j];
                }
                else if(isAncestor(j, i, inTime, outTime)){
                    xor2=xorSubset[i];
                    xor1=xorSubset[j]^xorSubset[i];
                }
                else{
                    xor1=xorSubset[i];
                    xor2=xorSubset[j];
                }
                xor3=xorSubset[0]^xor1^xor2;
                int max=Math.max(xor1, Math.max(xor2, xor3));
                int min=Math.min(xor1, Math.min(xor2, xor3));
                ans=Math.min(ans, max-min);
            }
        }
        return ans;
    }
}