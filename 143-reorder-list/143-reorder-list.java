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
    public void reorderList(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        int size = 0;
        ListNode it = head;
        
        while(it != null){
            ListNode next = it.next;
            it.next = null;
            ++size;
            map.put(size, it);
            it = next;
        }
        
        int bottomIndex = size;
        int startIndex = 1;
        head = new ListNode(-1);
        it = head;
        Queue<ListNode> queue = new LinkedList<>();
        while(startIndex < bottomIndex){
            queue.offer(map.get(startIndex));
            queue.offer(map.get(bottomIndex));
            ++startIndex;
            --bottomIndex;
        }
        if(queue.size() != size){
            queue.offer(map.get(bottomIndex));
        }
        while(!queue.isEmpty()){
            it.next = queue.poll();
            it = it.next;
        }
        head = head.next;
    }

}