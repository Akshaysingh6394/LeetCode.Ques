class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                list.add(nums1[i]);
                i++;
            }else{
                list.add(nums2[j]);
                j++;
            }
        }
        while(i<nums1.length){
            list.add(nums1[i]);
            i++;
        }
        while(j<nums2.length){
            list.add(nums2[j]);
            j++;
        }
        int n = list.size();
        double ans = 0;
        if(n % 2 ==0){
            int sum = list.get(n/2) + list.get((n/2)-1);
            ans =(sum/2.0);
        }else{
            ans = list.get(n/2);
        }
        return ans;
    }
}