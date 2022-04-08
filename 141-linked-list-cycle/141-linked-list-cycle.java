/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode copy = head;
        HashSet<ListNode> set = new HashSet();
        
        while(copy != null){
            if(set.contains(copy))
                return true;
            
            set.add(copy);
            copy = copy.next;
        }
        
        return false;
    }
}