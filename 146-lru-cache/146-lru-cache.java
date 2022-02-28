class LRUCache {
    int capacity;
    final ListNode head = new ListNode(0,0);
    final ListNode tail = new ListNode(0,0);
    HashMap<Integer, ListNode> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = tail;
        this.tail.prev = head;
        map = new HashMap<>(capacity);
    }
    
    public int get(int key) {
        ListNode current = map.get(key);
        if(current != null){
            remove(current);
            insert(current);
            return current.val;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        ListNode current = map.get(key);
        if(current != null){
            remove(current);
        } 
        
        if(map.size() == this.capacity){
            remove(tail.prev);
        }
        
        
            
        current = new ListNode(key, value);
    
        
        insert(current);
    }
    
    // Create a function to insert into our doubly linked list
    public void insert(ListNode node){
        map.put(node.key, node);
        ListNode next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }
    
    // Create a function to remove from a listnode
    public void remove(ListNode node){
        map.remove(node.key);
        ListNode next = node.next;
        ListNode prev = node.prev;
        next.prev = prev;
        prev.next = next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// Create a ListNode class which will essentially be a double ended linked list
// It will hold a key and value of integer type
// It will also hold pointers to the previous and next listNodes
class ListNode{
    int key;
    int val;
    ListNode prev;
    ListNode next;
    
    public ListNode(int key, int value){
        this.key = key;
        this.val = value;
    }
}