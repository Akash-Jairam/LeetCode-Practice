class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort()
        
        currInterval = intervals[0]
        res = []
        for i in range(1, len(intervals)):
            if currInterval[1] >= intervals[i][0]:
                currInterval = [min(currInterval[0], intervals[i][0]), max(currInterval[1], intervals[i][1])]
            else:
                res.append(currInterval)
                currInterval = intervals[i]
        
        res.append(currInterval)
        
        return res