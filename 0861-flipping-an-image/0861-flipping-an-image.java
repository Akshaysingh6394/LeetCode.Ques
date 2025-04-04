class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int row = image.length;
        int col = image[0].length;
        int start = 0;
        int end = col-1;
        for(int i=start;i<row;i++){
            start = 0;
            end = col-1;
            while(start<=end){
                int temp = image[i][start];
                image[i][start] = image[i][end]^1;
                image[i][end] = temp^1;
                start++;
                end--;
            }

        }
        return image;
    }
}