# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        nodes = []
        it = head
        
        while it:
            nodes.append(it)
            it = it.next
        
        l, r = 0, len(nodes) - 1
        front, idx = True, 0
        it = ListNode(-1)
        newHead = it
       
        while l <= r:
            if front:
                nodes[l].next = None
                it.next = nodes[l]
                it = it.next
                l += 1
            else:
                nodes[r].next = None
                it.next = nodes[r]
                it = it.next
                r -= 1
            
            front = not front
        
        