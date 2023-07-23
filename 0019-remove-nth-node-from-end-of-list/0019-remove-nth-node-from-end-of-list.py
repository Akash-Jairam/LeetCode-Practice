# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        
        it = head
        
        for i in range(n):
            it = it.next
        
        if not it:
            return head.next
        prev = head
        while it.next:
            prev = prev.next
            it = it.next
        
        prev.next = prev.next.next 
        return head