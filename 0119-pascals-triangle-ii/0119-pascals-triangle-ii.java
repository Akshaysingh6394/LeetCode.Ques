class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<>();
        
        long val = 1;
        for(int j=0;j<=rowIndex;j++){
            list.add((int)val);
            val = val * (rowIndex-j)/(j+1);
        }
        return list;
    }
}