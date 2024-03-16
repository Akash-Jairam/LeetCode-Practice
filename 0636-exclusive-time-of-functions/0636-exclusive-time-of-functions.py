class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        execTime = [0] * n
        stack = []
        
        for log in logs:
            split = log.split(':')
                           
            if split[1] == 'start':
                startTime = int(split[2])
                if stack:
                    i = stack[-1][0]
                    execTime[i] += startTime - stack[-1][1]
                stack.append([int(split[0]), startTime])
            elif split[1] == 'end':
                i, start = stack.pop()
                end = int(split[2]) + 1
                execTime[i] += end - start
                if stack:
                    stack[-1][1] = end
        
        return execTime