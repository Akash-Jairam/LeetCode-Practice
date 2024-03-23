# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
            Find the middle of the list
            Reverse the part of the list after the midpt
            Interleave the nodes from the beginning of the list and the beginning of the reversed Nodes
            TC: O(N)
            SC: O(1)
        """
        
        slow, fast = head, head.next
        
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        second = slow.next
        slow.next = None
        first, second = head, self.reverse(second)
        
        while second:
            tmp1, tmp2 = first.next, second.next
            first.next = second
            second.next = tmp1
            first, second = tmp1, tmp2
        
        
        
        
    def reverse(self, node):
        prev = None
        
        while node:
            nxt = node.next
            node.next = prev
            prev = node
            node = nxt
        
        return prev