class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        idx, n = 0, len(pushed)
        j = 0
        stack = []
        
        while j < n or idx < n:
            if stack and stack[-1] == popped[j]:
                stack.pop()
                j += 1
            elif idx < n:
                stack.append(pushed[idx])
                idx += 1
            else:
                break
        
        return len(stack) == 0