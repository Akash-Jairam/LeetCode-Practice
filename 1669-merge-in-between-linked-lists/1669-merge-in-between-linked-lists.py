# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        it = list1
        
        i = 0
        while i < a - 1:
            it = it.next
            i += 1
            
        start = it
        while i < b:
            it.next = it.next.next
            i += 1
          
        end = it.next
        start.next = list2
        
        while list2.next:
            list2 = list2.next
        
        list2.next = end
        
        return list1