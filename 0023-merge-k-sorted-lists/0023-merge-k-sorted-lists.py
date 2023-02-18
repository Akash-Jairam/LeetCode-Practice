# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        lists = [l for l in lists if l]
        if not lists:
            res = ListNode()
            return res.next
        lists.sort(key = lambda l: l.val)
        
        curr = lists[0]
        
        for i in range(1, len(lists)):
            it = curr
            curr_list = lists[i]
            while curr_list:
                if it.val < curr_list.val:
                    while it.next and it.next.val < curr_list.val:
                        it = it.next
                nxt = curr_list.next
                curr_list.next = it.next
                it.next = curr_list
                it = it.next
                curr_list = nxt
        
        return curr
                