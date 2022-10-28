class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a map of String keys and list values and assign keys of the sorted characters of the string
        // If a character is equal to that sorted character, we add it to that list
        // Return our list
        
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            map.put(new String(array), new ArrayList<>());
        }
        
        for(String str: strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String sortedString = new String(array);
            if(map.containsKey(sortedString)){
                map.get(sortedString).add(str);
            }
        }
        
        return new ArrayList<>(map.values());
    }
}