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
        ListNode first = head;
        int count = 1;
        
        while(count < k){
            first = first.next;
            ++count;
        }
        
        head = reverse(head);
        ListNode second = head;
        count = 1;
        
        while(count < k){
            second = second.next;
            ++count;
        }
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return reverse(head);
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        return prev;
    }
}