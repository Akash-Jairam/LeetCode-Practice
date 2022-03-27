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
    public ListNode reverseList(ListNode head) {
        ListNode newHead = head;
        ListNode prev = null;
        
        while(newHead != null){
            ListNode next = newHead.next;
            newHead.next = prev;
            prev = newHead;
            newHead = next;
        }
        
        return prev;
    }
}