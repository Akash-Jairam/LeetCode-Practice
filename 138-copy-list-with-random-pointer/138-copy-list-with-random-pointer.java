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
        // Copy each node and insert the copied node next to its original
        while(iter != null){
            Node copy = new Node(iter.val);
            next = iter.next;
            iter.next = copy;
            copy.next = next;
            iter = next;
        }
        
        // Now that a copied node is next to its original, we can assign the random values of the copies to the node next to the original randoms
        iter = head;
        while(iter != null){
            
            if(iter.random != null){
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }
        
        // Unweave the nodes to return the copied list and return the list to its original form    
        iter = head;
        Node copiedHead = new Node(0);
        Node copyTracker = copiedHead;
        while(iter != null){
            next = iter.next.next;
            copyTracker.next = iter.next;
            iter.next = next;
            iter = iter.next;
            copyTracker = copyTracker.next;
        }
        
        return copiedHead.next;
    }
}