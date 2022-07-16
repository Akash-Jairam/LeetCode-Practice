class AllOne {
    ValueNode head, tail;
    LinkedHashMap<String, ValueNode> map;
    public AllOne() {
        head = new ValueNode(0);
        tail = new ValueNode(0);
        head.next = tail;
        tail.prev = head;
        map = new LinkedHashMap<>();
    }
    
    public void inc(String key) {
        ValueNode curr = map.getOrDefault(key, head);
        ValueNode vn = curr.next;
        if(vn.val != curr.val + 1){
            vn = new ValueNode(curr.val + 1);
            vn.insertAt(curr.next);
        }
        vn.keys.add(key);
        map.put(key, vn);
        if(curr != head)
            curr.remove(key);
    }
    
    public void dec(String key) {
        ValueNode node = map.get(key);
        if(node == null)
            return;
        
        if(node.val == 1){
            node.remove(key);
            map.remove(key);
            return;
        }
        
        ValueNode prev = node.prev;
        if(prev.val != node.val -1){
            prev = new ValueNode(node.val -1);
            prev.insertAt(node);
        }
        prev.keys.add(key);
        map.put(key, prev);
        node.remove(key);
    }
    
    public String getMaxKey() {
        return tail.prev != head ? tail.prev.keys.iterator().next() : ""; 
    }
    
    public String getMinKey() {
        return head.next != tail ? head.next.keys.iterator().next() : "";
    }
}

class ValueNode{
    ValueNode prev, next;
    LinkedHashSet<String> keys;
    int val;
    
    public ValueNode(int val){
        this.val = val;
        this.keys = new LinkedHashSet<>();
    }
    
    public void insertAt(ValueNode node){
        ValueNode prev = node.prev;
        ValueNode next = node.next;
        prev.next = this;
        this.prev = prev;
        this.next = node;
        node.prev = this;
    }
    
    public void remove(String key){
        keys.remove(key);
        if(keys.isEmpty()){
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