class Solution {
    public boolean canReorderDoubled(int[] arr) {
        // Create a tree map and put all the numbers in there along with their count
        // Iterate through the lowest keys in the tree map and decrement their counts
        // If the number is less than zero, we should assume that it is doubled and we need to get the key of the number that is closer to zero
        // If it is greater than zero, we check for the key os its doubled and reduce that count
        // If the key's count is greater than the double's count we return false;
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for(int num : arr){
            tree.put(num, tree.getOrDefault(num, 0) + 1);
        }
        
        for(int key : tree.keySet()){
            if(key < 0){
                if(tree.getOrDefault(key/2,0) < tree.get(key))
                    return false;
                else if(key % 2 == -1 && tree.get(key) != 0)
                        return false;
                else{
                    
                    for(int i = 0; i < tree.get(key); ++i){
                        tree.put(key/2, tree.get(key/2) -1);
                    }
                }
            }
         else{
            if(tree.get(key) > tree.getOrDefault(key + key, 0))
                return false;
            
            for(int i = 0; i < tree.get(key); ++i ){
                tree.put(key + key, tree.get(key+key) -1);
            }
        }
        }
        
        return true;
    }
}