# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(float('inf'), head)
        it = dummy
        
        while it and it.next:
            while it.next and it.val == it.next.val:
                it.next = it.next.next
            else:
                it = it.next
        
        return dummy.next