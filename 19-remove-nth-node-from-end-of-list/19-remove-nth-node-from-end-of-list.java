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
        int size = 0;
        
        while(it != null){
            it = it.next;
            ++size;
        }
        
        if(size - n < 1)
            return head.next;
        
        int count = 0;
        ListNode first = head;
        ListNode second = head;
        
        while(count < n){
            second = second.next;
            ++count;
        }
        
        while(second.next != null){
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        
        return head;
    }
}