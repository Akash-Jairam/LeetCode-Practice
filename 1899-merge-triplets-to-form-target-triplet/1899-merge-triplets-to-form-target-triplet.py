class Solution:
    def mergeTriplets(self, triplets: List[List[int]], target: List[int]) -> bool:
        merged = set()
       
        for t in triplets:
            if t[0] > target[0] or t[1] > target[1] or t[2] > target[2]:
                continue
                
            for i in range(len(t)):
                if t[i] == target[i]:
                    merged.add(i)
            
            
        return len(merged) == 3