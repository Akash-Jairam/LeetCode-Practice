class SummaryRanges(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.intervals = []
        self.seen = set()

    def addNum(self, val):
        """
        :type val: int
        :rtype: None
        """      
        if val not in self.seen:
            self.seen.add(val)
            heapq.heappush(self.intervals, [val, val])
        
    def getIntervals(self):
        """
        :rtype: List[List[int]]
        """
        
        tmp = []

        while self.intervals:
            cur = heapq.heappop(self.intervals)
            if tmp and cur[0] <= tmp[-1][1] + 1:
                tmp[-1][1] = max(tmp[-1][1], cur[1])
            else:
                tmp.append(cur)

        self.intervals = tmp
        return self.intervals