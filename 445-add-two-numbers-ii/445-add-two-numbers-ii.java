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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Length = size(l1);
        int l2Length = size(l2);
        ListNode result = null;
        
        while(l1Length > 0 && l2Length > 0){
            int val1 = 0;
            int val2 = 0;
            
            if(l1Length >= l2Length){
                val1 = l1 != null ? l1.val : 0;
                l1 = l1.next;
                l1Length--;
            }
            
            if(l2Length >= l1Length + 1){
                val2 = l2 != null ? l2.val : 0;
                l2 = l2.next;
                l2Length--;
            }
            
            ListNode node = new ListNode(val1+val2);
            node.next = result;
            result = node;
        }
        
        int carry = 0;
        ListNode prev = null;
        
        while(result != null){
            ListNode next = result.next;
            ListNode current = new ListNode((result.val + carry) % 10);
            current.next = prev; 
            prev = current;
            carry = (result.val + carry) / 10;
            result = next;   
        }
        
        if(carry != 0){
            ListNode node = new ListNode(carry);
            node.next = prev;
            prev = node;
        }
        
        return prev;
    }
    
    public int size(ListNode node){
        int length = 0;
        
        while(node != null){
            node = node.next;
            ++length;
        }
        return length;
    }
}