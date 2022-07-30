class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        int[] bMap = new int[26];
        
        for(String b : words2){
            int[] curr = map(b);
            for(int i = 0; i < 26; ++i){
                bMap[i] = Math.max(bMap[i], curr[i]);
            }
        }
        
        for(String a : words1){
            int[] aMap = map(a);
            boolean isUniversal = true;
            for(int i = 0; i < 26; ++i){
                if(bMap[i] > aMap[i]){
                    isUniversal = false;
                    break;
                }
            }
            
            if(isUniversal)
                res.add(a);
        }
        return res;
    }
    
    public int[] map(String s){
        int[] map = new int [26];
        
        for(int i = 0; i < s.length(); ++i){
            map[s.charAt(i) - 'a']++;
        }
        return map;
    }
}