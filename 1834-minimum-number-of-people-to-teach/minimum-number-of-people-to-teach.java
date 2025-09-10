class Solution {
    public int minimumTeachings(int languageNumber, int[][] languages, int[][] friendships) {
        var languagesSets = new ArrayList<Set<Integer>>();
        for (int[] lang : languages) {
            var set = new HashSet<Integer>();
            for (int l : lang) {
                set.add(l);
            }
            languagesSets.add(set);
        }
        
        var notReachable = new ArrayList<int[]>();
        for (int[] friendship : friendships) {
            int from = friendship[0];
            int to = friendship[1];
            var intersection = new HashSet<>(languagesSets.get(from - 1));
            intersection.retainAll(languagesSets.get(to - 1));
            if (intersection.isEmpty()) {
                notReachable.add(new int[]{from - 1, to - 1});
            }
        }
        
        var learnLanguage = new HashSet<Integer>();
        int ans = Integer.MAX_VALUE;
        for (int language = 1; language <= languageNumber; language++) {
            learnLanguage.clear();
            int current = 0;
            for (int[] pair : notReachable) {
                int from = pair[0];
                int to = pair[1];
                if (!languagesSets.get(from).contains(language) && !learnLanguage.contains(from)) {
                    learnLanguage.add(from);
                    current++;
                }
                if (!languagesSets.get(to).contains(language) && !learnLanguage.contains(to)) {
                    learnLanguage.add(to);
                    current++;
                }
            }
            ans = Math.min(ans, current);
        }
        
        return ans;
    }
}