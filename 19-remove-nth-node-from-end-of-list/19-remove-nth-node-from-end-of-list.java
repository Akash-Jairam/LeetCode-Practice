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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode it = head;
        ListNode copy = head;
        int length = 0;
        
        while(copy != null){
            copy = copy.next;
            ++length;
        }
        
        if((n == 1 && length == 1) || n - length == 0){
            head = head.next;
            return head;
        }
        for(int i = 0; i < length-n; ++i){
            prev = prev.next;
            it = it.next;
        }
        
        prev.next = it.next;
        
        return head;
        
    }
}