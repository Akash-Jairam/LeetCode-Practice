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
        // Go through every node in the list from the current node
        // Create a pointer that will point to the previous node
        // Assign the value of the the current node to the value of the next node
        // point the prev node to the curr node 
        // Point the curr node to the next node
        // When we have finished traversing, point the prev node to null thereby reducing the list size
        ListNode prev = null;
        
        while(node.next != null){
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        
        prev.next = null;
    }
}