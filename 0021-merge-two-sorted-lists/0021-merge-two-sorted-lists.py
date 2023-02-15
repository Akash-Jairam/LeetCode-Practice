# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        newList = ListNode(-1)
        it = newList
        
        
        while list1 or list2:
            n1 = list1.val if list1 else float('inf')
            n2 = list2.val if list2 else float('inf')
            
            if n1 <= n2:
                nxt = list1.next
                list1.next = None
                it.next = list1
                list1 = nxt
            else:
                nxt = list2.next
                list2.next = None
                it.next = list2
                list2 = nxt
                
                
            it = it.next
        
        return newList.next