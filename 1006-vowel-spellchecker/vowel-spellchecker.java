class Solution {
    private boolean isVowel(char ch){
        if(ch == 'a'|| ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')return true;
        return false;
    }
    private String hashFunc(String w){
        String s = "";
        for(int i = 0; i < w.length(); ++i){
            char ch = w.charAt(i);
            if(isVowel(Character.toLowerCase(ch)))s += (i+1);
        }

        return s;
    } 

    private String canSensitive(String s,List<String> list){
        for(int i = 0 ; i < list.size();++i){
            String st = list.get(i);
            if(s.toLowerCase().equals(st.toLowerCase()))return st;
        }
        return "";
    }

    private boolean canFind(String s, String st){
        StringBuilder sb = new StringBuilder();
        if(s.length() != st.length())return false;

        for(int i = 0 ; i <st.length();++i){
            char ch = s.charAt(i);
            boolean f = true;
            if(isVowel(Character.toLowerCase(ch))){
                char ch1 = st.charAt(i);
                f = false;
                sb.append(ch1);
            }
            if(f)sb.append(ch);
        }

        String k = sb.toString();
        return k.toLowerCase().equals(st.toLowerCase());
    }

    private String canMatch(String s,List<String> list){
        for(int i = 0 ; i < list.size();++i){
            
                if(canFind(s,list.get(i)))return list.get(i);
            
        }

        return "";
    }
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashMap<String,List<String>> map = new HashMap<>();
        LinkedHashSet<String> set = new LinkedHashSet<>();

        for(int i = 0 ; i < wordlist.length; ++i){
            String s = wordlist[i];
            String hf = hashFunc(s);
            set.add(s);
            if(map.containsKey(hf)){
                List<String> list = map.get(hf);
                list.add(s);
                map.put(hf,list);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(hf,list);
            }
        }

        String[] ans = new String[queries.length];
        for(int i = 0 ; i < queries.length; ++i){
            String s = queries[i];
            String hf = hashFunc(s);
            if(set.contains(s)){
                ans[i] = s;
            }else if(map.containsKey(hf) == false){
                ans[i] = "";
            }else{
                String st = canSensitive(s,map.get(hf));
                if(st.equals("")){
                    ans[i] = canMatch(s,map.get(hf));
                }else{
                    ans[i] = st;
                }
            }
        }

        return ans;
    }
}