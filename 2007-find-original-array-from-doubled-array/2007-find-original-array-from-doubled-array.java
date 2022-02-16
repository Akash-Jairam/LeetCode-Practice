class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length % 2 == 1)
            return new int[0];
        
        int index = 0;
        int[] result = new int[changed.length /2];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int num : changed){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int key : map.keySet()){
            if(map.get(key) > map.getOrDefault(key + key, 0))
                return new int[0];
            
            for(int i = 0; i < map.get(key); ++i){
                result[index] = key;
                index++;
                map.put(key + key, map.get(key + key) - 1);
                
            }
        }
            return result;

    }
    
}