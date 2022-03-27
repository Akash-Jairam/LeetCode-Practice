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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        // The head of our first half
        ListNode l1 = head;
        // The tail of our last half
        ListNode fast = head;
        // The head of our second half
        ListNode slow = head;
        // THE tail of our first half
        ListNode prev = null;
        
        while(fast != null && fast.next != null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        
        prev.next = null;
        slow = reverse(slow);
        head = new ListNode(-1);
        ListNode iter = head;
        boolean flip = false;
        
        while(l1 != null || slow != null){
            int l1Val = l1 == null ? 1001 : l1.val;
            int l2Val = slow == null ? 1001 : slow.val;
            
            if(!flip && l1 != null){
                ListNode next = l1.next;
                l1.next = null;
                iter.next = l1;
                iter = iter.next;
                l1 = next;
            } else if (slow != null){
                ListNode next = slow.next;
                slow.next = null;
                iter.next = slow;
                iter = iter.next;
                slow = next;
            }
            flip = !flip;
        }
    }
    
    public ListNode reverse(ListNode node){
        ListNode prev = null;
        
        while(node != null){
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}