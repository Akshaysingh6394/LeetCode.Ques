class Solution {
    public List<List<Integer>> generate(int numRows) {
         List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));

            for (int j = 1; j < i; j++) {
                int val = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                row.set(j, val);
            }

            result.add(row);
        }

        return result;
    }
}