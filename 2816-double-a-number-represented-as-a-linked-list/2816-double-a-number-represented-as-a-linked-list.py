# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def doubleIt(self, head: Optional[ListNode]) -> Optional[ListNode]:
        curr = 0
        it = head
        while it:
            curr = curr * 10 + it.val
            it = it.next
        
        curr *= 2
        it = head
        prev = None
        while it:
            it.val = curr % 10
            curr //= 10
            prev = it
            it = it.next
        
        it = prev
        while curr:
            it.next = ListNode(curr % 10)
            curr //= 10
        
        prev = None
        while head:
            nxt = head.next
            head.next = prev
            prev = head
            head = nxt
        return prev