class Solution {
    public int totalFruit(int[] fruits) {
        // Create a map to keep track of each fruit and it's last index
        // Create a variable to keep track of the max number of fruits
        // Find some way to access each type of fruit in the map
        // If we encounter a new fruit that is not in the map and that size of the map is 2
        // We remove the type of fruit that was not at the tree before the new fruit and insert the new fruit and its index/
        // Keep track of the last index of each fruit by updating the map
        // At the end of each loop check to see if we can increase the max variable
        // Return the max at the end of the program
        Map<Integer, Integer> map = new HashMap<>();
        int max = -1;
        int startIndex = 0;
        
        for(int i = 0; i < fruits.length; ++i){
            if(!map.containsKey(fruits[i]) && map.size() == 2){
                int min = Integer.MAX_VALUE;
                int key = -1;
                for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                    if(entry.getValue() < min){
                        min = entry.getValue();
                        key = entry.getKey();
                    }
                }
                startIndex = min + 1;
                map.remove(key);
            }
            max = Math.max(max, i - startIndex + 1);
            map.put(fruits[i], i);
        }
        
        return max;
    }
    
}