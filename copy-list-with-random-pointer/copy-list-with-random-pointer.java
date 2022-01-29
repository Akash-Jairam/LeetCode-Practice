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
// If head == null, return null
        // Create a pointer and point it to the head
        // Iterate through the list to make a copy of each node and insert it next to the original node
        // Assign our pointer back to the head and iterate through our list again
        // Now that we know each copy is located next to its original, we will initialize the random pointers of our copied nodes to the pointer that is next to the random pointer of the original
        // We will then remove the copied node and add it to our copied list
        // Return our copied list
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node iter = head;
        Node deepCopy = new Node(-1);
        Node copyIter = deepCopy;
        while(iter != null){
            Node copy = new Node(iter.val);
            Node next = iter.next;
            iter.next = null;
            copy.next = next;
            iter.next = copy;
            iter = next;
        }
        
        iter = head;
        while(iter != null){
            if(iter.random != null)
                iter.next.random = iter.random.next;
            iter = iter.next.next;
        }
        
        iter = head;
        while(iter != null){
            Node next = iter.next.next;
            copyIter.next = iter.next;
            iter.next = iter.next.next;
            iter = iter.next;
                
            
            copyIter = copyIter.next;
        }
        
        return deepCopy.next;
    }
}