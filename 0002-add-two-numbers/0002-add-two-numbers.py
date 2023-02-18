# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        newList = ListNode(-1)
        it = newList
        carry = 0
        while l1 or l2:
            num1 = l1.val if l1 else 0
            num2 = l2.val if l2 else 0
            
            total = num1 + num2 + carry
            carry = total // 10
            it.next = ListNode(total %  10)
            
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
            it = it.next
        
        if carry:
            it.next = ListNode(carry)
        
        return newList.next
            