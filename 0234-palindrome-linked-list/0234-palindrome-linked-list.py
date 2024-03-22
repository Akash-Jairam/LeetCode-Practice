# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        vals = []
        
        it = head
        
        while it:
            vals.append(it.val)
            it = it.next
        
        i, j = 0, len(vals) -1
        
        while i < j:
            if vals[i] != vals[j]:
                return False
            
            i += 1
            j -= 1
        
        return True