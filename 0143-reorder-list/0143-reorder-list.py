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
        # Use slow and fast pointers to get to the midpoint of the list
        # Reverse the midpoint of the list
        # Now you have pointers to the front and back
        # Use those pointers to reassemble the list
        # Be mindful of those pointers converging
        def reverse(node):
            
            prev = None
            while node:
                nxt = node.next
                node.next = prev
                prev = node
                node = nxt
            return prev
            
        slow, fast = head, head
        
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        back = slow.next
        slow.next = None
        front, back = head, reverse(back)
        
        while back:
            f_nxt, b_nxt = front.next, back.next
            front.next, back.next = back, f_nxt
            front, back = f_nxt, b_nxt
        
            
        