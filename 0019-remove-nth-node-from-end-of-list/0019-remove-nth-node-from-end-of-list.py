# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        it, size = head, 0
        
        while it:
            it = it.next
            size += 1
        
        
        prev = ListNode(-1)
        prev.next = head
        it = head
        
        if not size - n:
            return head.next
        
        for i in range(size - n):
            prev = prev.next
            it = it.next
        
        prev.next = prev.next.next
        return head