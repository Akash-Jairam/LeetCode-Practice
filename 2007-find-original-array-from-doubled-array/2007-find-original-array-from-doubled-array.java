class Solution {
    public int[] findOriginalArray(int[] changed) {
        // Create a treeMap to track each number and its count
        // put the elements of the array into the treemap while making sure to update the count if needed
        // Iterate through the treemap's keys and check to see if the double of the key is in the map. If it is, decrement the occurrence of the double according to the occurence of the key. And add the key to the list for each decrement
        // If not, return a blank array
        // Convert the list to an array and return it.
        if(changed.length % 2 == 1)
            return new int[0];
        int[] arr = new int[changed.length/2];
        int index = 0;
        List<Integer> list = new ArrayList<>();
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for(int num : changed){
            tree.put(num, tree.getOrDefault(num, 0) + 1);
        }
        
        for(int key : tree.keySet()){
            if(tree.get(key) > tree.getOrDefault(key + key, 0))
                return new int[0];
            
            for(int i = 0; i < tree.get(key); ++i){
                tree.put(key + key, tree.get(key + key) -1);
                arr[index++] = key;
            }
        }
        
        return arr;
    }
}