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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode fakeHead = new ListNode(0, head);
        ListNode prev = fakeHead;
        ListNode curr = prev;
        int pos = 0;
        
        while(pos < left){
            ++pos;
            prev = curr;
            curr = curr.next;
        }
        
        ListNode first = curr;
        ListNode next = curr.next;
        while(pos < right){
            ListNode temp = next.next;
            next.next = curr;
            ++pos;
            curr = next;
            next = temp;
        }
        
        first.next = next;
        prev.next = curr;
        
        return fakeHead.next;
    }
}