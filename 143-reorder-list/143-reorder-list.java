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
        if(head == null || head.next == null) return;
        // Find the middle of the list
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        // Reverse the second half
        ListNode l1 = head;
        ListNode l2 = reverse(slow);
        // Merge the two halves
        ListNode res = new ListNode(-1);
        ListNode it = res;
        
        while(l1 != null || l2 != null){
            if(l1 != null){
                it.next = l1;
                it = it.next;
                l1 = l1.next;
            }
            
            if(l2 != null){
                it.next = l2;
                l2 = l2.next;
                it = it.next;
            }
        }
        
        
        head = res.next;
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