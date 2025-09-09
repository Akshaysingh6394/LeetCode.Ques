class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long people = 0;
        int mod = (int) 1e9 + 7;
        Map<Integer, Long> peopleMap = new TreeMap<>();
        peopleMap.put(1, 1L);
        for (int i = 1; i < n; i++) {
            Map<Integer, Long> newPeopleMap = new TreeMap<>();
            for(Map.Entry<Integer, Long> entry : peopleMap.entrySet()) {
                int key = entry.getKey();
                long value = entry.getValue();
                if(key < forget) {
                    newPeopleMap.put(key+1, (newPeopleMap.getOrDefault(key+1, Long.valueOf(0))+value)%mod);
                    if(key >= delay) {
                        newPeopleMap.put(1, (newPeopleMap.getOrDefault(1, Long.valueOf(0))+value)%mod);
                    }
                }

            }
            peopleMap = newPeopleMap;
        }
        for(Map.Entry<Integer, Long> entry : peopleMap.entrySet()) {
            people = (people + entry.getValue())%mod;
        }
        return (int) people;
    }
}