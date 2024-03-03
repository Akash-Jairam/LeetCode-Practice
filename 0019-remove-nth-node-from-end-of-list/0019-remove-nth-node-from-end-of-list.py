# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(-1, head)
        left = dummy
        it = head
        
        for i in range(n):
            it = it.next
        
        while it:
            it = it.next
            left = left.next
        
        left.next = left.next.next
        return dummy.next