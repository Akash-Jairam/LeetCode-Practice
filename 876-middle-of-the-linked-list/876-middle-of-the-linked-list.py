# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        size = 0
        tail = head
        while tail != None:
            tail = tail.next
            size += 1
            
        mid = head
        midIndex = size // 2
        midIndexInt = midIndex
        for x in range(midIndexInt):
            mid = mid.next
            
        return mid
        