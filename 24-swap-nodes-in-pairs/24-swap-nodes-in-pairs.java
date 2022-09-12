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
    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return head;
        
        if(head.next != null){
            ListNode next = head.next.next;
            ListNode imNext = head.next;
            imNext.next = null;
            head.next = next;
            imNext.next = head;
            head = imNext;
            head.next.next = swapPairs(head.next.next);
        }
        
        return head;
    }
}