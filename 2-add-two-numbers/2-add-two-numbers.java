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
        ListNode head = new ListNode();
        int sum = (l1.val + l2.val);
        head.val = sum % 10;
        int carryOverValue = sum/10;
        ListNode copy = head;
        l1 = l1.next;
        l2 = l2.next;
        
        while(l1 != null && l2 != null){
            sum = (l1.val + l2.val) + carryOverValue;
            if(sum >= 10){   
                carryOverValue = sum / 10;
                sum = sum % 10;
            } else{
                carryOverValue = 0;
            }
            copy.next = new ListNode(sum);
            copy = copy.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        if(l1 == null && l2 != null){
           AddSingleNode(l2, copy, carryOverValue);
        } else if(l2 == null && l1 != null){
           AddSingleNode(l1, copy, carryOverValue);
        } else if(carryOverValue > 0){
            copy.next = new ListNode(carryOverValue);
        }
        return head;
    }
    
    public void AddSingleNode(ListNode l3, ListNode copy, int carryOverValue){
        while(l3 != null){
            int sum = l3.val + carryOverValue;
            copy.next = new ListNode((sum % 10));
            carryOverValue = sum/10;
            copy = copy.next;
            l3 = l3.next;
        }
        if(carryOverValue > 0){
            copy.next = new ListNode(carryOverValue);
        }
    }
}