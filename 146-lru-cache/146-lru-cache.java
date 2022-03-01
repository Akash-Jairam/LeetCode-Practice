class LRUCache {
    final ListNode head = new ListNode(0,0);
    final ListNode tail = new ListNode(0,0);
    HashMap<Integer, ListNode> cache;
    int capacity;
    // Create pointers to the head and tail of our doubly linked list
    // Create a hashmap that will store the key as the key and the ListNode as the value
    public LRUCache(int capacity) {
        // The constructor will initialize our map and capacity
        // It will also connect the head to the tail
        this.capacity = capacity;
        this.cache = new HashMap(capacity);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if(this.cache.containsKey(key)){
            ListNode node = this.cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(this.cache.containsKey(key)){
            remove(this.cache.get(key));
        } else {
            if(this.cache.size() == this.capacity)
                remove(this.tail.prev);
        }
        
        insert(new ListNode(key, value));
    }
    
    public void insert(ListNode node){
        // First, we will inset the entry from our map using the key value stored in the node and the node itself
        // Next, we will get the reference to the next element after the head
        // We will assign the head's next to the given node and the node's prev to the head
        // Similarly, we will assign the node's next to the reference and the reference's prev to the node
        this.cache.put(node.key, node);
        ListNode next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }
    
    public void remove(ListNode node){
        // First, we will remove the node from the cache using the node's key
        // Second, we will find the reference to the node's next node and the node's previous node
        // We'll set the node's next node's prev to point to the previous node
        // We'll set the previous node's next to point to the next node
        this.cache.remove(node.key);
        ListNode next = node.next;
        ListNode previous = node.prev;
        previous.next = next;
        next.prev = previous;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// Create a ListNode (LinkedList class) that will hold a key, value of int type and pointers to the next and previous nodes
public class ListNode{
    int key;
    int val;
    ListNode next;
    ListNode prev;
    
    public ListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}