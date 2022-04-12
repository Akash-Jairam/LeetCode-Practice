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
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((l1, l2) -> (l1.val - l2.val));
        
        for(ListNode list : lists){
            if(list != null)
                pq.offer(list);
        }
        
        ListNode res = new ListNode(-1);
        ListNode it = res;
        
        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            if(curr.next != null)
                pq.offer(curr.next);
            
            curr.next = null;
            it.next = curr;
            it = it.next;
        }
        
        return res.next;
    }
}