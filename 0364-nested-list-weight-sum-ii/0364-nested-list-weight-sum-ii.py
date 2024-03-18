# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger:
#    def __init__(self, value=None):
#        """
#        If value is not specified, initializes an empty list.
#        Otherwise initializes a single integer equal to value.
#        """
#
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def add(self, elem):
#        """
#        Set this NestedInteger to hold a nested list and adds a nested integer elem to it.
#        :rtype void
#        """
#
#    def setInteger(self, value):
#        """
#        Set this NestedInteger to hold a single integer equal to value.
#        :rtype void
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        """
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """
from collections import deque
class Solution:
    def depthSumInverse(self, nestedList: List[NestedInteger]) -> int:
     # depth = max depth - depth of integer + 1
    # sum of integers(depth) = sum of integers(max depth + 1) - sum of integers(dept of integer)
        q = deque()
        q.extend(nestedList)
        sumOfIntegers = 0
        sumTimesDepth = 0
        depth = 1
        
        while q:
            size = len(q)
            for _ in range(size):
                curr = q.popleft()
                if curr.isInteger():
                    sumOfIntegers += curr.getInteger()
                    sumTimesDepth += curr.getInteger() * depth
                else:
                    q.extend(curr.getList())
    
            depth += 1
        
        depth -= 1
        return sumOfIntegers * (depth + 1) - sumTimesDepth