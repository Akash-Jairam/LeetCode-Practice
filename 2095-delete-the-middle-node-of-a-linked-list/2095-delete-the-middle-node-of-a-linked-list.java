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
    public ListNode deleteMiddle(ListNode head) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode it = head;
        int numNodes = 0;
        
        while(it != null){
            ++numNodes;
            it = it.next;
        }
        
        it = head;
        int midPos = numNodes / 2;
        if(numNodes == 1)
            return null;
        for(int i = 0; i < midPos; ++i){
            prev = prev.next;
            it = it.next;
        }
        
        prev.next = prev.next.next;
        return head;
    }
}