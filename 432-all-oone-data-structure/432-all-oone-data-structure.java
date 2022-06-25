class AllOne {
    
    HashMap<String, Integer> map;
    TreeMap<Integer, List<String>> tree;
    
    public AllOne() {
        map = new HashMap<>();
        tree = new TreeMap<>();
    }
    
    public void inc(String key) {
        int count =  map.getOrDefault(key, 0);
        map.put(key, count + 1);
        if(tree.containsKey(count))
            tree.get(count).remove(key);
        tree.putIfAbsent(map.get(key), new ArrayList<>());
        tree.get(map.get(key)).add(key);
    }
    
    public void dec(String key) {
        int count = map.get(key);
        tree.get(count).remove(key);
        if(count == 1){
            map.remove(key);
        } else{
            map.put(key, count - 1);
            tree.putIfAbsent(count, new ArrayList<>());
            tree.get(count - 1).add(key);
        }
    
    }
    
    public String getMaxKey() {
        while(tree.size() > 0 && tree.get(tree.lastKey()).size() == 0){
            tree.pollLastEntry();
        }
        TreeMap<Integer, List<String>> tree2 = tree;
        return tree.size() == 0 ? "" : tree.get(tree.lastKey()).get(0);
    }
    
    public String getMinKey() {
        for(List<String> val : tree.values()){
            if(val.size() > 0)
                return val.get(0);
        }
        
        return "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */