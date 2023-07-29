# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        '''
            Use a dummy pointer to function as the original previous position
            Find the end of the current set of k nodes while keeping track of the current position and the previous position
            Reverse this segment
            Attach the new beginning of this segment to after the previous position
            Update the previous position to point to the position that it was initially pointing to
            Keep doing this until we reach the end of the list
            
        '''
        dummy = ListNode(-1, head)
        groupPrev = dummy
        
        while True:
            kth = self.getKth(groupPrev, k)
            if not kth:
                break
            groupNext = kth.next
            
            # Reverse the k nodes
            prev, curr = kth.next, groupPrev.next
            while curr != groupNext:
                nxt = curr.next
                curr.next = prev
                prev = curr
                curr = nxt
            
            nxt = groupPrev.next
            groupPrev.next = kth
            groupPrev = nxt
        
        return dummy.next
    
    def getKth(self, node, k):
        while node and k > 0:
            node = node.next
            k -= 1
        
        return node