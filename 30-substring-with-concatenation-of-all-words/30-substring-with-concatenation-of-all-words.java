class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> counts = new HashMap<>();
        
        for(String word : words){
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        
        List<Integer> indexes = new ArrayList<>();
        int n = s.length(), num = words.length, len = words[0].length();
        
        for(int i = 0; i < n - num * len + 1; ++i){
            String sub = s.substring(i, i + num * len);
            if(isConcat(sub, counts, len)){
                indexes.add(i);
            }
        }
        
        return indexes;
    }
    
    private boolean isConcat(String sub, HashMap<String, Integer> counts, int wordLen){
        HashMap<String, Integer> seen = new HashMap<>();
        for(int i = 0; i < sub.length(); i+= wordLen){
            String sWord = sub.substring(i, i+wordLen);
            seen.put(sWord, seen.getOrDefault(sWord, 0) + 1);
        }
        
        return seen.equals(counts);
    }
}