class StockPrice {
    int current = -1;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    HashMap<Integer, Integer> map;
    TreeMap<Integer, Integer> tree;
    public StockPrice() {
        map = new HashMap<>();
        tree = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        int currPrice = map.getOrDefault(timestamp, -1);
        if(tree.containsKey(currPrice)){
            tree.put(currPrice, tree.get(currPrice) - 1);
            if(tree.get(currPrice) == 0)
                tree.remove(currPrice);
        }
        map.put(timestamp, price);
        tree.put(price, tree.getOrDefault(price, 0) + 1);
        max = tree.lastKey();
        min = tree.firstKey();
        current = Math.max(current, timestamp);
    }
    
    public int current() {
        return map.getOrDefault(current, -1);
    }
    
    public int maximum() {
        return max;
    }
    
    public int minimum() {
        return min;
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