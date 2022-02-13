class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit){
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>(Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < values.length; ++i){
            treeMap.putIfAbsent(values[i], new ArrayList<>());
            treeMap.get(values[i]).add(labels[i]);
        }
        
        
        int sum = 0;
        int count = 0;
        
        for(int key : treeMap.keySet()){
            if(count == numWanted){
                break;
            }
            for(int label : treeMap.get(key)){
                if(count == numWanted)
                    break;
                if(map.getOrDefault(label, 0) < useLimit){
                    sum += key;
                    ++count;
                    map.put(label, map.getOrDefault(label,0) + 1);
                }
            }
        }
        
        return sum;
    }
}