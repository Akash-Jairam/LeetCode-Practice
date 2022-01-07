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
    public ListNode middleNode(ListNode head) {
        ListNode tail = head;
        int listSize = 1;
        int midPoint = 0;
        
        if(head.next == null)
            return head;
        
        while(tail.next != null){
            tail = tail.next;
            listSize++;
        }
        
         midPoint = listSize/2;
        
        while(midPoint > 0){
            head = head.next;
            midPoint--;
        }
        
        return head;
    }
}