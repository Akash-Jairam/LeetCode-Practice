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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(-1);
        ListNode curr = res;
        
        if(list1 == null)
            return list2;
        else if(list2 == null)
            return list1;
        
        while(list1 != null || list2 != null){
            int l1Val = 101;
            int l2Val = 101;
            if(list1 != null)
                l1Val = list1.val;
            
            if(list2 != null)
                l2Val = list2.val;
            
            if(l1Val > l2Val) {
               ListNode next = list2.next;
                list2.next = null;
                curr.next = list2;
                list2 = next;
            } else   {              
                ListNode next = list1.next;
                list1.next = null;
                curr.next = list1;
                list1 = next;
            }
            if(curr != null)
                curr = curr.next;
        }
        return res.next;
    }
}