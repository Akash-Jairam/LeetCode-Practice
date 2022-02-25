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
        int s1 = size(l1);
        int s2 = size(l2);
        
        ListNode resultHead = null;
        ListNode n = null;
        
        while(l1 != null || l2 != null){
            int v1 = 0;
            int v2 = 0;
            if(s1 >= s2){
                v1 = l1 != null ? l1.val : 0;
                l1 = l1.next;
                s1--;
            }
            
            if(s2 >= s1 +1){
                v2 = l2 != null ? l2.val : 0;
                l2 = l2.next;
                s2--;
            }
            
            n = new ListNode(v1 + v2);
            n.next = resultHead;
            resultHead = n;
        }
        
        int carry = 0;
        resultHead = null;
        
        // Normalize
        while(n != null){
            n.val += carry;
            if(n.val >= 10){
                n.val = n.val % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            
            ListNode next = n.next;
            n.next = resultHead;
            resultHead = n;
            n = next;
            
        }
        
        if(carry > 0){
            n = new ListNode(1);
            n.next = resultHead;
            resultHead = n;
        }
        
        return resultHead;
    }
    
    public int size(ListNode node){
        int s = 0;
        while(node != null){
            node = node.next;
            ++s;
        }
        return s;
    }
}