# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        res = ListNode(-1)
        lists = [l for l in lists if l]
        if not lists:
            return res.next
        lists.sort(key = lambda l : l.val)
        res.next = lists[0]
        it = res.next
        
        for i in range( 1, len(lists)):
            l2 = lists[i]
            while l2:
                it_v = it.next.val if it.next else float('inf')
                if l2.val <= it_v:
                    nxt = l2.next
                    l2.next = it.next
                    it.next = l2
                    l2 = nxt
                else:
                    it = it.next
            it = res.next
        return res.next