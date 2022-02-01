class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String s = new String(array);
            if(map.containsKey(s)){
                map.get(s).add(str);
            }else{
                map.put(s, new ArrayList<>());
                map.get(s).add(str);
            }
        }
        
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}