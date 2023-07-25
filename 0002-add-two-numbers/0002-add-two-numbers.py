# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        res = ListNode(-1)
        it = res
        carry = 0
        while l1 or l2:
            l1v, l2v = 0, 0
            
            if l1:
                l1v = l1.val
                l1 = l1.next
            
            if l2:
                l2v = l2.val
                l2 = l2.next
            
            total = l1v + l2v + carry
            carry = total // 10
            it.next = ListNode(total % 10)
            it = it.next
        
        if carry:
            it.next = ListNode(carry)
        return res.next