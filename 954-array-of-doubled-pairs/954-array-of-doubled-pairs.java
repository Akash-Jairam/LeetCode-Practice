class Solution {
    public boolean canReorderDoubled(int[] arr) {
        if(arr.length % 2 ==1)
            return false;
            
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        
        for(int num : arr){
            tree.put(num, tree.getOrDefault(num, 0) + 1);
        }
        
        for(int key : tree.keySet()){
            if(tree.get(key) == 0)
                continue;
            int val = key < 0 ? key / 2 : key * 2;

            if(key < 0 && key % 2 != 0 || tree.get(key) > tree.getOrDefault(val, 0))
                return false;
            
            
            tree.put(val, tree.get(val) - tree.get(key));
        }
        
        return true;
    }
}