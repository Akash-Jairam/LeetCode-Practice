import heapq
class MedianFinder:

    def __init__(self):
        self.min_heap, self.max_heap = [], []

    def addNum(self, num: int) -> None:
        # Add the element to the max Heap 
        # Remove the top element from the max heap and add it to the min heap
        # If the min heap's size is greater than the max heap, remove the bottom element in the min heap
        # and add to the max heap
        heapq.heappush(self.max_heap, num * -1)
        heapq.heappush(self.min_heap, -1 * heapq.heappop(self.max_heap))
        
        if len(self.min_heap) > len(self.max_heap):
            heapq.heappush(self.max_heap, -1 * heapq.heappop(self.min_heap))
        

    def findMedian(self) -> float:
        if len(self.max_heap) > len(self.min_heap):
            return float(self.max_heap[0] * -1)
        else:
            return ((-1 * self.max_heap[0]) + self.min_heap[0]) / 2


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()