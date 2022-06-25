class AllOne {
    ValueNode valueHead, valueTail;
    Map<String, ValueNode> keys;
    
    public AllOne() {
        valueHead = new ValueNode(0);
        valueTail = new ValueNode(0);
        valueHead.next = valueTail;
        valueTail.prev = valueHead;
        keys = new HashMap<>();
    }
    
    public void inc(String key) {
        ValueNode node = keys.getOrDefault(key, valueHead);
        ValueNode vn = node.next;
        
        if(vn.val != node.val + 1){
            vn = new ValueNode(node.val + 1);
            vn.insertAt(node.next);
        }
        
        vn.strs.add(key);
        keys.put(key, vn);
        if(node != valueHead) node.remove(key);
    }
    
    public void dec(String key) {
        ValueNode node = keys.get(key);
        if(node == null) return;
        
        if(node.val == 1){
            keys.remove(key);
            node.remove(key);
            return;
        }
        
        ValueNode prev = node.prev;
        if(prev.val != node.val - 1){
            prev = new ValueNode(node.val - 1);
            prev.insertAt(node);
        }
        
        prev.strs.add(key);
        keys.put(key, prev);
        node.remove(key);
    }
    
    public String getMaxKey() {
        if(valueTail.prev != valueHead){
            return valueTail.prev.strs.iterator().next();
        }
        
        return "";
    }
    
    public String getMinKey() {
        if(valueHead.next != valueTail){
            return valueHead.next.strs.iterator().next();
        }
        
        return "";
    }
}

class ValueNode{
    ValueNode next;
    ValueNode prev;
    int val;
    Set<String> strs;
    
    public ValueNode(int val){
        this.val = val;
        strs = new LinkedHashSet<>();
    }
    
    // Places this node between the given node and its predecessor
    public void insertAt(ValueNode node){
        next = node;
        prev = node.prev;
        prev.next = this;
        next.prev = this;
    }
    
    public void remove(String str){
        strs.remove(str);
        // If no strings are in the node, remove it from the chain
        if(strs.isEmpty()){
            prev.next = next;
            next.prev = prev;
        }
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