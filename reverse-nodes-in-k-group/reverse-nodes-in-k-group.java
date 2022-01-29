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
        //Assign two pointers to the head node, one to iterate through the list and "khead" to keep track of the first node to reverse
        //Create a counter to track the number of elements
        //When the counter reaches k, we call our reverse function and pass "khead", the current node and k. Our function returns the new head of the reversed node
        // If it is the first time we call this function, we will update the head of the list
        // For all other times, we will segment the function using "ktail" and "khead" to make sure that only the nodes within the range are reversed
        // We will reconnect the nodes after the reversal is done
        // Return the head
        ListNode iterator = head;
        ListNode ktail = head;
        ListNode khead = head;
        int count = 0;
        while(iterator != null){
            count++;
            if(count == k){
                if(khead == head){
                    head = reverse(khead, iterator, count);
                } else {
                    ListNode next = ktail.next;
                    ktail.next = null;
                    ktail.next = reverse(khead, iterator, count);
                }
                ktail = khead;
                iterator = khead.next;
                khead = iterator;
                count = 0;
                continue;
            }
            iterator = iterator.next;
        }
        return head;
    }
    
    public ListNode reverse(ListNode head, ListNode tail, int k){
        ListNode copy = head;
        ListNode prev = null;
        ListNode next = tail.next;
        tail.next = null;
        
        while(k > 0){
            // Make a reference to nodes after current
            ListNode nextNodes = copy.next;
            // Current now points to the previous nodes before it
            copy.next = prev;
            // Assign previous to current node
            prev = copy;
            // Assign current node to the "next node"
            copy = nextNodes;
            k--;
        }
        head.next = next;
        return tail;
    }
}