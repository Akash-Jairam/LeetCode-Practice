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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Save the previous reversed pointer in prev and in each iteration use prev.next to set the previous ptr to the current reversed.
        ListNode tempNode = new ListNode(0);
        tempNode.next = head;
        ListNode tempHead = tempNode.next;
        ListNode prev = tempNode;
        while(tempHead!=null){
            // Take note of the current node
            ListNode klast = tempHead;
            int count = k;
            while(count > 0 && tempHead != null){
                tempHead = tempHead.next;
                count--;
            }
            if(count != 0){
                prev.next = klast;
                break;
            }
            
            ListNode kfirst = reverse(klast, k);
            prev.next = kfirst;
            prev = klast;
        }
        return tempNode.next;
        
    }
    
    // Standard reverse code
    public ListNode reverse(ListNode head, int k){
        ListNode prev = null;
        
        while(head != null && k > 0){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            k--;
        }
        
        return prev;
    }
    
}
