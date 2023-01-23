class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        trust_arr, trusted_arr = [0] * (n + 1), [0] * (n+1)
        
        for truster, trustee in trust:
            trust_arr[truster] += 1
            trusted_arr[trustee] += 1
            
        res = -1
        
        for i in range(1, n+1):
            if trust_arr[i] == 0 and trusted_arr[i] == n - 1:
                res = i
        
        return res
             
        