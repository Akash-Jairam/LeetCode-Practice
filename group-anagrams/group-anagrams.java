class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a map
        // Iterate through array
        // Sort current string and check to see if it is in our map
        // If it is not in our map, put it in the map with a new arraylist
        // Retrieve the key with using the sorted string and add the current string to our map
        // Return a new list with the values of the map
        Map<String, ArrayList<String>> map = new HashMap<>();
        for(String str : strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}