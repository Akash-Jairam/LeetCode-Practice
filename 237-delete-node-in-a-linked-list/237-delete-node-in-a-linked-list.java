/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode copy = node;
        while(node.next != null){
            node.val = node.next.val;
            copy = node;
            node = node.next;
        }
        copy.next = null;
    }
}