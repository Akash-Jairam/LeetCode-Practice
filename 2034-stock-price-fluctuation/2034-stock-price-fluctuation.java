class StockPrice {
    TreeMap<Integer, Integer> map;
    TreeMap<Integer, List<Integer>> tree;
    public StockPrice() {
        map = new TreeMap<>();
        tree = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        if(map.containsKey(timestamp)){
            int prevPrice = map.get(timestamp);
            tree.get(prevPrice).remove(Integer.valueOf(timestamp));
            if(tree.get(prevPrice).size() == 0) tree.remove(prevPrice);
        }
        
        tree.putIfAbsent(price, new ArrayList<>());
        tree.get(price).add(timestamp);
        map.put(timestamp, price);
    }
    
    public int current() {
        return map.get(map.lastKey());
    }
    
    public int maximum() {
        return tree.lastKey();
    }
    
    public int minimum() {
        return tree.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */