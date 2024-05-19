# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(-1)
        it = head
        n_map = [0] * 101
        
        while it:
            n_map[it.val] += 1
            it = it.next
        
        i1 = dummy
        i2 = head
        
        while i2:
            if n_map[i2.val] == 1:
                nxt = i2.next
                i2.next = None
                i1.next = i2
                i2 = nxt
                i1 = i1.next
            else:
                i2 = i2.next
            
            
        
        return dummy.next
        