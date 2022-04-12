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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        
        ListNode curr = lists[0];
        for(int i = 1; i < lists.length; ++i){
            ListNode temp = new ListNode(-1);
            ListNode it = temp;
            while(curr != null || lists[i] != null){
                int currVal = curr == null ? Integer.MAX_VALUE : curr.val;
                int listVal = lists[i] == null ? Integer.MAX_VALUE : lists[i].val;
                
                if(currVal < listVal){
                    ListNode next = curr.next;
                    curr.next = null;
                    it.next = curr;
                    curr = next;
                } else {
                    ListNode next = lists[i].next;
                    lists[i].next = null;
                    it.next = lists[i];
                    lists[i] = next;
                }
                it = it.next;
            }
            curr = temp.next;
        }
        
        return curr;
    }
}