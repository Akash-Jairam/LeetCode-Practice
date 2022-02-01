class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            map.put(new String(array), new ArrayList<>());
        }
        
        for(int i = 0; i < strs.length; ++i){
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            String sorted = new String(array);
            if(map.containsKey(sorted))
                map.get(sorted).add(strs[i]);
        }
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}