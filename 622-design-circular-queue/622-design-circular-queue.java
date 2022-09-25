class MyCircularQueue {
    Node head, tail;
    int size;
    int currSize;
    public MyCircularQueue(int k) {
        this.size = k;
        this.currSize = 0;
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public boolean enQueue(int value) {
        if(currSize < size){
            tail.insertPrev(new Node(value));
            ++currSize;
            return true;
        }
        
        return false;
    }
    
    public boolean deQueue() {
        if(currSize > 0){
            head.next.remove();
            --currSize;
            return true;
        }
        
        return false;
    }
    
    public int Front() {
        if(currSize > 0) return head.next.val;
        
        return -1;
    }
    
    public int Rear() {
        if(currSize > 0) return tail.prev.val;
        
        return -1;
    }
    
    public boolean isEmpty() {
        return currSize == 0;
    }
    
    public boolean isFull() {
        return currSize == size;
    }
}

class Node{
    int val;
    Node next;
    Node prev;
    
    public Node(int val){
        this.val = val;
    }
    
    public void insertPrev(Node curr){
        Node prev = this.prev;
        curr.prev = prev;
        prev.next = curr;
        curr.next = this;
        this.prev = curr;
    }
    
    public void insertNext(Node curr){
        Node next = this.next;
        this.next = curr;
        curr.prev = this;
        curr.next = next;
        next.prev = curr;
    }
    
    public void remove(){
        this.prev.next = this.next;
        if(this.next != null)
            this.next.prev = this.prev;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */