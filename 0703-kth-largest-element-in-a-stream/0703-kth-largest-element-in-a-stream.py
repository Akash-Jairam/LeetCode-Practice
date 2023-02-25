import heapq
class KthLargest:
    def __init__(self, k: int, nums: List[int]):
        self.heap = nums
        self.k = k
        self.heap.sort()
        self.balance()
        

    def add(self, val: int) -> int:
        heapq.heappush(self.heap, val)
        self.balance()
        return self.heap[0]

    def balance(self):
        while len(self.heap) > self.k:
            heapq.heappop(self.heap)
            
# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)