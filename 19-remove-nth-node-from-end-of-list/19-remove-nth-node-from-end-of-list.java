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
        ListNode it = head;
        for(int i = 0; i < n; ++i){
            it = it.next;
        }
        
        if(it == null){
            return head.next;
        }
        
        ListNode nth = head;
        while(it != null){
            it = it.next;
            nth = nth.next;
        }
        
        it = head;
        while(it.next != nth){
            it = it.next;
        }
        
        it.next = it.next.next;
        return head;
    }
}