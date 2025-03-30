class Solution {
    public String addBinary(String a, String b) {
        int al = a.length();
        int bl = b.length();
        int sum=0;
        int c = 0;
        String aans="";
        int i=0;
        while(i<al || i<bl || c!=0 ){
            int x=0;
            if(i<al && a.charAt(al-i-1)=='1'){
                x=1;
            }
            int y=0;
            if(i<bl && b.charAt(bl-i-1)=='1'){
                y=1;
            }
           aans = ((x + y + c) % 2) + aans;
            // aans = (an) + aans;
            c = (x + y + c)/2;
            i+=1;
        }
        return aans;
        
    }
}