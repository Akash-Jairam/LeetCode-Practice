/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Make pointers to the List's head
        // Iterate through the list while keeping track of the current element and the count of nodes
        // If the count is evenly divisible by k, we will reverse the elements from the previous reversal point to the current point
        // When reversing, we will segregrate the reversed section from the rest of the list and reattach it when we are done
        // Return the list
        ListNode copy = head;
        ListNode iterator = copy;
        ListNode khead = copy;
        int count = 0;
        ListNode ktail = khead;
        
        while(iterator != null){
            count++;
            if(count == k){
                if(khead == head){
                    ktail = khead;
                    ListNode next = iterator.next;
                    iterator.next = null;
                    head = reverse(khead, iterator, k);
                    iterator = next;
                    ktail.next = next;
                    khead = iterator;
                    count = 0;
                    continue;
                }else {
                    ListNode next = iterator.next;
                    iterator.next = null;
                    ktail.next = null;
                    ktail.next = reverse(khead, iterator, k);
                    ktail = khead;
                    ktail.next = next;
                    iterator = next;
                    khead = iterator;
                    count = 0;
                    continue;
                }
            }
            iterator = iterator.next;
        }
        
        return  head;
    }
    
    public ListNode reverse(ListNode head, ListNode tail, int k){
        int counter = k;
        ListNode copy = head;
        ListNode prev = null;
        ListNode next = tail.next;
        tail.next = null;
        while(counter > 0){
            // Assign a pointer to the next node(s) in the LinkedList
            ListNode nextNodes = copy.next;
            // Link the current node to the node(s) before it
            copy.next = prev;
            // Update the previous node to the current node
            prev = copy;
            // Update the current node to the next node
            copy = nextNodes; 
            counter--;
        }
        head.next = next;
        return tail;
        
        
    }
}