class Solution:
    def heightChecker(self, heights: List[int]) -> int:
        n_map = [0] * 101
        res = 0
        for h in heights:
            n_map[h] += 1
        
        expected = []
        for i in range(len(n_map)):
            for j in range(n_map[i]):
                expected.append(i)
        
        for i in range(len(heights)):
            if heights[i] != expected[i]:
                res += 1
        
        return res