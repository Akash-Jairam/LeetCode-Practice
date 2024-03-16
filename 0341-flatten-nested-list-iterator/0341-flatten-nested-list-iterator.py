# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger:
#    def isInteger(self) -> bool:
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        """
#
#    def getInteger(self) -> int:
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        """
#
#    def getList(self) -> [NestedInteger]:
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        """
from collections import deque
class NestedIterator:
    def __init__(self, nestedList: [NestedInteger]):
        self.list = self.flatten(nestedList)
        self.i = 0
        
    def next(self) -> int:
        res = self.list[self.i]
        self.i += 1
        return res
    
    def hasNext(self) -> bool:
         return self.i < len(self.list)
        
    def flatten(self, nestedList):
        tmp = []
        q = deque()
        q.extend(nestedList)
        
        while q:
            size = len(q)
            for _ in range(size):
                curr = q.popleft()
                if curr.isInteger():
                    tmp.append(curr)
                else:
                    q.extendleft(curr.getList()[::-1])
        
        return tmp
    

# Your NestedIterator object will be instantiated and called as such:
# i, v = NestedIterator(nestedList), []
# while i.hasNext(): v.append(i.next())