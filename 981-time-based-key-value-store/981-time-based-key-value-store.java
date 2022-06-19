class TimeMap {
    
    HashMap<String, List<Pair<Integer, String>>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";
        else{
            return binarySearch(timestamp, map.get(key));
        }  
    }
    
    public String binarySearch(int timeStamp, List<Pair<Integer, String>> list){
        int start = 0, end = list.size() - 1;
        
        while(start < end){
            int mid = start + (end - start) / 2;
            if(list.get(mid).getKey() > timeStamp)
                
                end = mid - 1;
            else{
                if(list.get(mid+1).getKey() > timeStamp)
                    return list.get(mid).getValue();
                    start = mid + 1;
            }
        }
        
        return list.get(start).getKey() <= timeStamp ? list.get(start).getValue() : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */