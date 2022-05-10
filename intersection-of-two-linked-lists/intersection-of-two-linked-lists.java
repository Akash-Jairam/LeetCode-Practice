/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet();
        ListNode it = headA;
        while(it != null){
            set.add(it);
            it = it.next;
        }
        
        it = headB;
        while(it != null){
            if(set.contains(it))
                return it;
            it = it.next;
        }
        
        return null;
    }
}