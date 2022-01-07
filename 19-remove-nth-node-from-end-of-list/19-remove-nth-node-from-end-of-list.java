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
        ListNode tail = head;
        ListNode toRemove = head;
        int listSize = 1;
        int location = 0;
        
        while(tail.next != null){
            tail = tail.next;
            listSize++;
        }
        
        if(listSize == n){
            if(head.next == null)
                head = null;
            else
                head = head.next;
            return head;
        }
        
        location = listSize - n;
        
        while(location>1){
            toRemove = toRemove.next;
            location--;
        }
        
        toRemove.next = toRemove.next.next;
    
        return head;
        
    }
}