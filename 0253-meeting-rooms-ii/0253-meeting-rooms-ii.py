import heapq
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort()
        rooms = 1
        min_heap = []
        min_heap.append(intervals[0][1])
        for i in range(1, len(intervals)):
            if min_heap:
                if min_heap[0] > intervals[i][0]:
                    rooms += 1
                else:
                    heapq.heappop(min_heap)
            heapq.heappush(min_heap, intervals[i][1])
        return rooms