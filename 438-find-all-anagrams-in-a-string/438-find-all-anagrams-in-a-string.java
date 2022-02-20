class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] pMap = new int[26];
        int[] sMap = new int[26];
        int count = 0;
        for(char c : p.toCharArray()){
            pMap[c - 'a']++;
        }
        
        for(int i = 0; i < s.length(); ++i){
            sMap[s.charAt(i) - 'a']++;
            ++count;
            while(count > p.length()){
                sMap[s.charAt(i-count+1) - 'a']--;
                --count;
            }
            if(Arrays.equals(pMap, sMap)){
                result.add(i-count+1);
            }
        }
        
        return result;
    }
}