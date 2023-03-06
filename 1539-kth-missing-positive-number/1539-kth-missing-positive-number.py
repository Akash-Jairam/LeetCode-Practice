class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        idx, num = 0, 1
        
        while idx < len(arr) and k > 0:
            if num < arr[idx]:
                k -= 1
            else:
                idx += 1
            num += 1
        
        while k > 0:
            k -= 1
            num += 1
        return num - 1