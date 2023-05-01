class Solution:
    def average(self, salary: List[int]) -> float:
        if len(salary) < 3:
            return 0
        min_sal, max_sal = float('inf'), float('-inf')
        total = 0
        for s in salary:
            total += s
            min_sal = min(min_sal, s)
            max_sal = max(max_sal, s)
        
        return (total - (min_sal + max_sal)) / (len(salary) - 2)