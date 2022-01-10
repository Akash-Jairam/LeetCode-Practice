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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        
        while(head.val == val){
            if(head.next == null){
                head = null;
                return head;
            }
            else
                head = head.next;
        }
        
        ListNode copy = head;
        ListNode copy2 = head;
        
        while(copy != null){
            if(copy.val == val){
                copy2.next = copy.next;
            }else{
                copy2 = copy;
            }
            copy = copy.next;
        }
        return head;
    }
}