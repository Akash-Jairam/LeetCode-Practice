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
        ListNode res = new ListNode();
        ListNode it = res;
        
        while(list1 != null || list2 != null){
            int l1 = list1 == null ? 101 : list1.val;
            int l2 = list2 == null ? 101 : list2.val;
            
            if(l1 < l2){
                ListNode next = list1.next;
                list1.next = null;
                res.next = list1;
                res = res.next;
                list1 = next;
            } else {
                ListNode next = list2.next;
                list2.next = null;
                res.next = list2;
                res = res.next;
                list2 = next;
            } 
        }
        
        return it.next;
    }
}