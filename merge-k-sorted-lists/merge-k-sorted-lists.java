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
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y) -> Integer.compare(x,y));
        ListNode head = new ListNode(-1);
        ListNode driver = head;
        
        for(ListNode list : lists){
            while(list != null){
                pq.add(list.val);
                list = list.next;
            }
        }
        
        while(!pq.isEmpty()){
            driver.next = new ListNode(pq.remove());
            driver = driver.next;
        }
        
        return head.next;
    }
}