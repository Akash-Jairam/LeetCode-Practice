class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        last_i = {}
        res = []
        size = 0
        for i in range(len(s)):
            last_i[s[i]] = i
        
        goal = 0
        
        for i in range(len(s)):
            goal = max(goal, last_i[s[i]])
            size += 1
            if goal == i:
                res.append(size)
                size = 0
            
            
        
        return res