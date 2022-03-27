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
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((l1, l2) -> (l1.val - l2.val));
        ListNode res = new ListNode(-1);
        ListNode it = res;
        
        for(ListNode list : lists){
            while(list != null){
                ListNode next = list.next;
                list.next = null;
                pq.offer(list);
                list = next;
            }
        }
        
        while(!pq.isEmpty()){
            it.next = pq.remove();
            it = it.next;
        }
        
        return res.next;
    }
}