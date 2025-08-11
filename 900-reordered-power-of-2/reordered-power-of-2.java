class Solution {
    public boolean reorderedPowerOf2(int n) {
        HashMap<Integer, Integer> digitMap = new HashMap<Integer, Integer>();
		int iNum = n;
		long powerOfTwo = 1;
		digitMap = getDigitMap(iNum);
		while(powerOfTwo <= Integer.MAX_VALUE) {
			HashMap<Integer, Integer> powerOfTwoMap = getDigitMap((int)powerOfTwo);
			if(powerOfTwoMap.equals(digitMap)) {
				return true;
			}
            powerOfTwo = powerOfTwo << 1;
		}
		
		return false;
	}
	private HashMap<Integer, Integer> getDigitMap(int iNum) {
		HashMap<Integer, Integer> digitMap = new HashMap<Integer, Integer>();
		while(iNum > 0) {
			int digit = iNum % 10;
			digitMap.put(digit, digitMap.getOrDefault(digit, 0) + 1);
			iNum /= 10;
		}
		return digitMap;
	}
}