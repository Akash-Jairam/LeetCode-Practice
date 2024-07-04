# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        it = head
        dummy = ListNode(-1)
        dit = dummy
        while it:

            while it and it.next and it.next.val != 0:
                it.val += it.next.val
                it.next = it.next.next
                
            it = it.next
        
        it = head
        while it:
            if it.val:
                nxt = it.next
                it.next = None
                dit.next = it
                dit = dit.next
                it = nxt
            else:
                it = it.next
        
        return dummy.next
