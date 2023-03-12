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
        for l in lists[1:]:
            it = res.next
            while it and l:
                prev = it
                while it and it.val < l.val:
                    prev = it
                    it = it.next
                nxt = prev.next
                lnxt = l.next
                l.next = None
                prev.next = l
                prev.next.next = nxt
                if not it:
                    prev.next.next = lnxt
                    break
                it = prev.next
                l = lnxt
                
        
        return res.next
            