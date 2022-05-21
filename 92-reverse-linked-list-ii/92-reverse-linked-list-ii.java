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
        int pos = 0;
        ListNode fakeHead = new ListNode(0, head);
        ListNode cur = fakeHead;
        ListNode prev = cur;
        
        while(pos < left){
            ++pos;
            prev = cur;
            cur = cur.next;
        }
        
        ListNode first = cur;
        ListNode next = cur.next;
        
        while(pos < right){
            ListNode tmp = next.next;
            next.next = cur;
            ++pos;
            cur = next;
            next = tmp;
        }
        
        first.next = next;
        prev.next = cur;
        
        return fakeHead.next;
    }
}