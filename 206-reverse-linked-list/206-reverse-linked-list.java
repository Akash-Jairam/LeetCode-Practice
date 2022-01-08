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
        if(head == null || head.next == null)
            return head;
        ListNode tail = head;
        ListNode temp = head;
        Stack<Integer> stack = new Stack<Integer>();
        
        
        
        while(tail.next != null){
            stack.push(tail.val);
            tail = tail.next;
        }
        ListNode copy = tail;
        
        while(!stack.isEmpty()){
            copy.next = new ListNode(stack.pop());
            copy = copy.next;
        }
        
        return tail;
    }
}