class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        res, stack = [0] * n, []
        
        for i in range(n):
            while stack and temperatures[i] > temperatures[stack[len(stack) -1]]:
                res[stack[len(stack) - 1]] = i - stack[-1]
                stack.pop()
            stack.append(i)
        
        return res
        