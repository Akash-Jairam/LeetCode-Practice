from collections import Counter
import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        num_map = Counter(nums)
        return heapq.nlargest(k, num_map.keys(), key=num_map.get)
            
        