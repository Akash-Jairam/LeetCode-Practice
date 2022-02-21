class Solution {
    public int totalFruit(int[] fruits) {
        // Create a map to keep track of each type of fruit in our baskets and their most recent index
        // Iterate through our fruits array, while making sure to update the number of fruits we currently have 
        // If we encounter a new type of tree that is not in our baskets, we iterate through our baskets and remove the type of tree  with the lowest index
        // We then update our max value before subtracting the lowest index from our current fruit count
        // We put the new type of fruit into our basket along with its index
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int count = 0;
        
        for(int i = 0; i < fruits.length; ++i){
            if(map.size() == 2 && !map.containsKey(fruits[i])){
                int min = Integer.MAX_VALUE;
                int minKey = -1;
                for(int key : map.keySet()){
                    if(map.get(key) < min){
                        min = map.get(key);
                        minKey = key;
                    }
                    
                }
                max = Math.max(count, max);
                if(map.get(minKey) == 0)
                    count--;
                count = i - map.get(minKey);
                map.remove(minKey);
                map.put(fruits[i], i);
                continue;
            }
            map.put(fruits[i], i);
            count++;
        }
        return Math.max(max, count);
    }
}