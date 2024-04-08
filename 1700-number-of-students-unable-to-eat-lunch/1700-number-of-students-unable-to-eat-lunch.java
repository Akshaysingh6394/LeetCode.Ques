class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int zero_cnt=0,one_cnt=0;
        for(int i=0;i<students.length;i++){
            if(students[i]==0){
                zero_cnt++;
            }else{
                one_cnt++;
            }
        }
        for(int i=0;i<sandwiches.length;i++){
            if(sandwiches[i]==0 && zero_cnt==0){
                return one_cnt;
            }
            if(sandwiches[i]==1 && one_cnt==0){
                return zero_cnt;
            }
            if(sandwiches[i]==0){
                zero_cnt--;
            }else{
                one_cnt--;
            }
        }
        return 0;
    }
}