class AllOne {
    // Create nodes for the head and tail
    ValueNode head, tail;
    // Create a linkedhashmap to store each string and the node that they are located on
    LinkedHashMap<String, ValueNode> map;
    
    public AllOne() {
        // Create head and tail as blank nodes and point them to each other
        // Create the linked hashmap
        this.head = new ValueNode(0);
        this.tail = new ValueNode(0);
        head.next = tail;
        tail.prev = head;
        map = new LinkedHashMap<>();
    }
    
    public void inc(String key) {
        // Try to get the node from the map
        // If the node is not in the map, get the head
        // If the value of the node next to the current node is not 1 more than current
        // Remove the key from the curr node if the current node is not the head
        // Add the key to the next node and put the key into the map with the next node
        ValueNode curr = map.getOrDefault(key, head);
        if(curr.next.val != curr.val + 1){
            ValueNode vn = new ValueNode(curr.val + 1);
            vn.insertAt(curr.next);
        }
        ValueNode next = curr.next;
        if(curr != head)
            curr.remove(key);
        next.keys.add(key);
        map.put(key, next);
        
    }
    
    public void dec(String key) {
        ValueNode curr = map.get(key);
        if(curr == null){
            return;
        }
        if(curr.val == 1){
            curr.remove(key);
            map.remove(key);
            return;
        }
        
        if(curr.prev.val != curr.val -1){
            ValueNode vn = new ValueNode(curr.val - 1);
            vn.insertAt(curr);
        }
        
        ValueNode prev = curr.prev;
        curr.remove(key);
        prev.keys.add(key);
        map.put(key, prev);
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

public class ValueNode{
    ValueNode prev, next;
    int val;
    LinkedHashSet<String> keys;
    
    
    public ValueNode(int val){
        this.val = val;
        keys = new LinkedHashSet<>();
    }
    
    public void insertAt(ValueNode next){
        ValueNode prev = next.prev;
        prev.next = this;
        this.prev = prev;
        this.next = next;
        next.prev = this;
    }
    
    public void remove(String key){
        keys.remove(key);
        if(keys.isEmpty()){
            prev.next = next;
            next.prev = prev;
        }
    }
}

/*
- Create a doubly linked list that will represent each count and store strings that have that count in a LinkedHashSet

- This class will have a two methods:
    -insertAt - which will accept a node and insert the current node between the given node and it's predecessor
    
    -remove - this will accept a given key and remove it from the LinkedHashSet. If the set is empty, we will remove the node itself from the list

*/

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */