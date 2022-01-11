class MyHashMap {
    ArrayList<Integer> keys;
    ArrayList<Integer> values;

    public MyHashMap() {
        keys = new ArrayList<Integer>();
        values = new ArrayList<Integer>();
    }
    
    public void put(int key, int value) {
        if(key < 0 || value < 0)
            return;
        for(int i = 0; i < keys.size(); i++){
            if(this.keys.get(i) == key){
                this.values.set(i, value);
                return;
            }
        }
        this.keys.add(key);
        this.values.add(value);
        
    }
    
    public int get(int key) {
        for(int i = 0; i < this.keys.size(); i++){
            if(this.keys.get(i) == key){
                return this.values.get(i);
            }
        }
        return -1;
        
    }
    
    public void remove(int key) {
        for(int i = 0; i < this.keys.size(); i++){
            if(this.keys.get(i) == key){
                this.keys.remove(i);
                this.values.remove(i);
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */