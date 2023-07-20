# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        res = ListNode(-1)
        it = res
        
        while list1 or list2:
            l1 = list1.val if list1 else float('inf')
            l2 = list2.val if list2 else float('inf')
            
            if l1 < l2:
                nxt = list1.next
                list1.next = None
                it.next = list1
                list1 = nxt
            else:
                nxt = list2.next
                list2.next = None
                it.next = list2
                list2 = nxt
            
            it = it.next
        
        return res.next