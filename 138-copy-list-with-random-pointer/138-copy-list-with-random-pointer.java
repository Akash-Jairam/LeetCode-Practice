/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node iter = head, next;
        
        // Make copy of list and weave it into existing list
        while(iter != null){
            Node copy = new Node(iter.val);
            next = iter.next;
            iter.next = copy;
            copy.next = next;
            iter = next;
        }
        
        
        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while(iter != null){
            next = iter.next.next;
            if(iter.random != null){
                iter.next.random = iter.random.next;
            }
            iter = next;
        }
        
        // Third round: restore the original list, and extract the copy list.
        iter = head;
        Node newHead = new Node(0);
        Node driver = newHead;
        while(iter != null){
            next = iter.next.next;
            driver.next = iter.next;
            iter.next = next;
            iter = iter.next;
            driver = driver.next;
        }
        
        return newHead.next;
    }
}