# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        l1, l2 = self.reverse(l1), self.reverse(l2)
        carry = 0
        res = ListNode(-1)
        it = res
        while l1 or l2:
            l1V = l1.val if l1 else 0
            l2V = l2.val if l2 else 0
            
            total = l1V + l2V + carry
            it.next = ListNode(total % 10)
            carry = total // 10
            
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
            it = it.next
        if carry:
            it.next = ListNode(carry)
        
        return self.reverse(res.next)
        
        
    
    def reverse(self, l):
        prev = None
        while l:
            nxt = l.next
            l.next = prev
            prev = l
            l = nxt
        
        return prev

    
    