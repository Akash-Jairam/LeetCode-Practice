class LRUCache {
    HashMap<Integer, ListNode> map;
    final ListNode head = new ListNode(0,0);
    final ListNode tail = new ListNode(0,0);
    Integer capacity;
    
    public LRUCache(int capacity) {
        map = new HashMap(capacity);
        this.capacity = capacity;
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        ListNode node = map.get(key);
        if(node != null){
            remove(node);
            insert(node);
            return node.val;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        ListNode current = map.get(key);
        if(current != null){
            remove(current);
            current = new ListNode(key, value);
        } else{
            current = new ListNode(key, value);
        }
        if(map.size() == capacity){
            remove(tail.prev);
        }
        
        insert(current);
        
        
            
    }
    
    public void insert(ListNode node){
        map.put(node.key, node);
        ListNode next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }
    
    public void remove(ListNode node){
        map.remove(node.key);
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}

class ListNode {
    int val;
    int key;
    ListNode prev;
    ListNode next;
    
    public ListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
    
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */