class Solution {
    public int maxLength(List<String> arr) {
        List<String> candidates = new ArrayList<>();
        backtrack(arr, 0, "", candidates);
        int max = 0;
        
        for(String s : candidates){
            max = Math.max(max, findUnique(s));
        }
        
        return max;
    }
    
    public void backtrack(List<String> arr, int index, String curr, List<String> candidates){
        if(index == arr.size()){
            candidates.add(curr);
            return;
        }
        if(!arr.contains(curr))
            candidates.add(curr);
        
        
        
            
        backtrack(arr, index+1, curr + "" + arr.get(index) , candidates);
        backtrack(arr, index+1, curr, candidates);
         
    }
    
    public int findUnique(String s){
        int[] map = new int[26];
        int count = 0;
        for(char c: s.toCharArray()){
            if(map[c - 'a'] > 0)
                return -1;
            map[c - 'a']++;
            ++count;
        }
        
        return count;
    }
}