import heapq
class MedianFinder:

    def __init__(self):
        self.max_heap, self.min_heap = [], []

    def addNum(self, num: int) -> None:
        if self.min_heap and self.min_heap[0] < num:
            heapq.heappush(self.min_heap, num)
        else:
            heapq.heappush(self.max_heap, -num)

        if len(self.min_heap) > len(self.max_heap):
            val = heapq.heappop(self.min_heap)
            heapq.heappush(self.max_heap, -val)
        
        if len(self.max_heap) > len(self.min_heap):
            val = -heapq.heappop(self.max_heap)
            heapq.heappush(self.min_heap, val)
        
    def findMedian(self) -> float:
        m, n = len(self.max_heap), len(self.min_heap)
        
        if m > n:
            return -self.max_heap[0]
        elif n > m:
            return self.min_heap[0]
        
        return  (-self.max_heap[0] + self.min_heap[0]) / 2


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()