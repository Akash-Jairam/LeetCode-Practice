import heapq
class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if not len(hand) % groupSize == 0:
            return False
        
        h_map = {}
        
        for c in hand:
            h_map[c] = 1 + h_map.get(c, 0)
            
        cards = list(h_map.keys())
        heapq.heapify(cards)
        
        while cards:
            curr = cards[0]            
            for i in range(curr, curr + groupSize):
                if i not in h_map:
                    return False
                h_map[i] -= 1
                if h_map[i] == 0:
                    if i != cards[0]:
                        return False
                    heapq.heappop(cards)
        
        return True
        
        