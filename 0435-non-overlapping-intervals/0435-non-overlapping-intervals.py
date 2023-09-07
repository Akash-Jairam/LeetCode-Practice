class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        res = 0
        intervals.sort(key = lambda x: x[1])
        curr = intervals[0]
        for i in range(1, len(intervals)):
            if intervals[i][0] < curr[1]:
                res += 1
            else:
                curr = intervals[i]
        
        return res