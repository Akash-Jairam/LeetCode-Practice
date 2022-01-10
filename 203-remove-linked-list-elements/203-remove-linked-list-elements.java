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
        if(head == null){
            return head;
        }
        while(head.val == val){
            if(head.next == null){
                head = null;
                return head;
            }else
                head = head.next;
        }
        
        ListNode iterator = head;
        ListNode lastGoodNode = head;
        while(iterator != null){
            if(iterator.val == val){
                lastGoodNode.next = iterator.next;
            } else{
                lastGoodNode = iterator;
            }
            iterator = iterator.next;
        }
        return head;
    }
}