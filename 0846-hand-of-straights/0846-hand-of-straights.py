import heapq
class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand) % groupSize:
            return False
        
        c_map = {}
        for c in hand:
            c_map[c] = 1 + c_map.get(c, 0)
            
        min_heap = list(c_map.keys())
        heapq.heapify(min_heap)
        
        while min_heap:
            curr = min_heap[0]
            
            for i in range(groupSize):
                if curr + i not in c_map or not c_map[curr + i]:
                    return False
                
                c_map[curr + i] -= 1
                if c_map[curr + i] == 0 and curr + i != heapq.heappop(min_heap):
                    return False
        
        return True
        
    
            
        
        