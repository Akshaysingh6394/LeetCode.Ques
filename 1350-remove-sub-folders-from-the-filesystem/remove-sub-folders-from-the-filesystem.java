class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>();
        
        Arrays.sort(folder);

        for (String s : folder) {
            
            if (ans.isEmpty() || !s.startsWith(ans.get(ans.size() - 1) + "/")) {
                ans.add(s); 
            } 
        }

        return ans; 
    }
}