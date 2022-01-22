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
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        
        List<Integer> list = new ArrayList<>();
        ListNode copy = head;
        while(copy != null){
            list.add(copy.val);
            copy = copy.next;
        }
        
        ListNode node = new ListNode(-1);
        ListNode pointer = node;
        for(int i = list.size()-1; i >= 0; i--){
            pointer.next = new ListNode(list.get(i));
            pointer = pointer.next;
        }
        
        return node.next;
    }
}