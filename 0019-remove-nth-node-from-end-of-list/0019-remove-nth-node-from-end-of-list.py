# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        prev = ListNode(-1, head)
        it = head
        newHead = prev
        
        for i in range(n):
            it = it.next
        
        while it:
            prev = prev.next
            it = it.next
        
        
        prev.next = prev.next.next
        return newHead.next