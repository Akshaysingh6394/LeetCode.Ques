class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <=n; i++) {
            list.add(i);
        }

        Map<String, int[]> map = new HashMap<>();
        return dfs(list, firstPlayer, secondPlayer, 1, map);
    }

    private int[] dfs(List<Integer> players, int firstPlayer, int secondPlayer, int round, Map<String, int[]> map) {
        int size = players.size();
        String key = players.toString();

        if (map.containsKey(key)) {
            return map.get(key);
        }

        for (int i = 0; i <size/2; i++) {
            int a = players.get(i);
            int b = players.get(size - 1 - i);
            if ((a == firstPlayer && b == secondPlayer) || (a == secondPlayer && b == firstPlayer)) {
                return new int[] {round, round};
            }
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int count = size/2;
        int mid;

        if (size % 2 == 1) {
            mid = players.get(size/2);
        } else {
            mid = -1;
        }

        for (int mask = 0; mask < (1 << count); mask++) {
            List<Integer> next = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                int a = players.get(i);
                int b = players.get(size - 1 - i);

                if (a == firstPlayer || a == secondPlayer) {
                    next.add(a);
                } else if (b == firstPlayer || b == secondPlayer) {
                    next.add(b);
                } else {
                    if ((mask & (1 << i)) == 0) {
                        next.add(b);
                    } else {
                        next.add(a);
                    }
                }
            }

            if (mid != -1) {
                next.add(mid);
            }

            Collections.sort(next);
            int[] result = dfs(next, firstPlayer, secondPlayer, round + 1, map);
            min = Math.min(min, result[0]);
            max = Math.max(max, result[1]);

        }
        int[] res = new int[] {min, max};
        map.put(key, res);
        return res;
    }
}