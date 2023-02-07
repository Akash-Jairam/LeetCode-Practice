class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        counter, i = {}, 0
        n = len(fruits)
        
        for j in range(n):
            f = fruits[j]
            counter[f] = counter.get(f, 0) + 1
            
            if len(counter) > 2:
                counter[fruits[i]] -= 1
                if counter[fruits[i]] == 0:
                    del counter[fruits[i]]
                i += 1
        
        return n - 1 - i + 1