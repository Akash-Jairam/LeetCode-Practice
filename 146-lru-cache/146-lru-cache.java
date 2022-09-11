class LRUCache {

    LinkedHashMap<Integer, Node> map = new LinkedHashMap<>();
    Node head, tail;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node curr = map.getOrDefault(key, null);
        int val = -1;
        if(curr != null){
            curr.remove();
            head.insertAt(curr);
            val = curr.val;
        }
        return val;
    }
    
    public void put(int key, int value) {
        Node curr = map.getOrDefault(key, null);
        if(curr != null){
            curr.val = value;
            curr.remove();
        } else{
            curr = new Node(key, value);
            map.put(key, curr);
        }
        head.insertAt(curr);
        if(map.size() > capacity) {
            map.remove(tail.prev.key);
            tail.prev.remove();
        }
    }
}

class Node{
    int key;
    int val;
    Node next;
    Node prev;
    
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
    
    public void remove(){
        this.prev.next = this.next;
        this.next.prev = this.prev;
    }
    
    public void insertAt(Node node){
        Node next = this.next;
        
        this.next = node;
        node.prev = this;
        
        node.next = next;
        next.prev = node;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */