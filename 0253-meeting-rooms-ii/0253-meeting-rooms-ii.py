import heapq
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort()
        min_heap = [intervals[0][1]]
        rooms = 1
        for i in range(1, len(intervals)):
            start, fin = intervals[i]
            if start < min_heap[0]:
                rooms += 1
            else:
                heapq.heappop(min_heap)
            
            heapq.heappush(min_heap, fin)
        
        return rooms
        