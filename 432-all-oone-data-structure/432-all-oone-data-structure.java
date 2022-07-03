class AllOne {
    ValueNode head,  tail;
    Map<String, ValueNode> keys;
    
    public AllOne() {
        head = new ValueNode(0);
        tail = new ValueNode(0);
        head.next = tail;
        tail.prev = head;
        keys = new HashMap<>();
    }
    
    public void inc(String key) {
        ValueNode node = keys.getOrDefault(key, head);
        ValueNode vn = node.next;
        
        if(vn.val != node.val + 1){
            vn = new ValueNode(node.val + 1);
            vn.insertAt(node.next);
        }
        
        vn.keys.add(key);
        keys.put(key, vn);
        if(node != head) node.remove(key);
    }
    
    public void dec(String key) {
        ValueNode node = keys.get(key);
        if(node == null)
            return;
        
        if(node.val == 1){
            node.remove(key);
            keys.remove(key);
        }
        
        ValueNode prev = node.prev;
        if(prev.val != node.val - 1){
            prev = new ValueNode(node.val - 1);
            prev.insertAt(node);
        }
        prev.keys.add(key);
        keys.put(key, prev);
        node.remove(key);
    }
    
    public String getMaxKey() {
        if(tail.prev != head){
            return tail.prev.keys.iterator().next();
        }
        
        return "";
    }
    
    public String getMinKey() {
        if(head.next != tail){
            return head.next.keys.iterator().next();
        }
        
        return "";
    }
}

class ValueNode{
    ValueNode next, prev;
    int val;
    Set<String> keys;
    
    public ValueNode(int val){
        this.val = val;
        this.keys = new LinkedHashSet<>();
    }
    
    public void insertAt(ValueNode node){
        next = node;
        prev = node.prev;
        prev.next = this;
        next.prev = this;
    }
    
    public void remove(String key){
        keys.remove(key);
        if(keys.isEmpty()){
            prev.next = next;
            next.prev = prev;
            return;
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