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
    public ListNode swapNodes(ListNode head, int k) {
        // Use two pointer method
        // Set both pointers to the head
        // For the first pointer
        // Traverse through the list until we reach the kth element from the front
        // Create a pointer and assign it to the first pointer
        // While the newest pointer is not equal to null, traverse the list while making sure to moveour second pointer in tandem
        // Since there is k distance between our 
        ListNode first = head;
        ListNode second = head;
        int count = 1;
        
        while(count < k){
            first = first.next;
            ++count;
        }
        
        ListNode it = first;
        while(it.next != null){
            it = it.next;
            second = second.next;
        }
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }
}