class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        numDays = [0] * len(temperatures)
        stack = []
        
        for i in range(len(temperatures)):
            while stack and stack[-1][0] < temperatures[i]:
                tmp, idx = stack.pop()
                numDays[idx] = i - idx
            
            stack.append((temperatures[i], i))
        
        return numDays