class RandomizedSet {
    HashMap<Integer, Integer> map;
    HashMap<Integer, Integer> map2;
    int key;
    
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.map2 = new HashMap<>();
        this.key = 0;
    }
    
    public boolean insert(int val) {
        if(!this.map2.containsKey(val)){
            ++key;
            map.put(key, val);
            map2.put(val, key);
            HashMap<Integer, Integer> h = this.map;
            return true;
        }  else{
            return false;
        }
    }
    
    public boolean remove(int val) {
        if(this.map2.containsKey(val)){
            this.map.remove(this.map2.get(val));
            this.map2.remove(val);
            HashMap<Integer, Integer> h = this.map;
            return true;
        } else
            return false;
    }
    
    public int getRandom() {
        HashMap<Integer, Integer> h = this.map;
        if(this.map.size() == 1){
            for(int key : map.keySet())
                return map.get(key);
        }
        Random random = new Random();
        int k = random.nextInt(this.key + 1);
        
        while(!map.containsKey(k)){
            k = random.nextInt(this.key + 1);
        }
        
        return map.get(k);
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */