# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        def reverse(node):
            prev = None
            
            while node:
                next_node = node.next
                node.next = prev
                prev = node
                node = next_node
            
            return prev
                
        res = []
        it, count, n = head, 0, 0
        
        while it:
            n += 1
            it = it.next
        
        it = head

        while it:
            if n - count < k:
                res.append(it)
                break
            prev = None
            for i in range(k):
                if not it:
                    break
                count += 1
                nxt = it.next
                it.next = prev
                prev = it
                it = nxt
            res.append(prev)
        
        for i in range(len(res) - 1):
            it = res[i]
            while it.next:
                it = it.next
            it.next = res[i+1]
        
        return res[0]