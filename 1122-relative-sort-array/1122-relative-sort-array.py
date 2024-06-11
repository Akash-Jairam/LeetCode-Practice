class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        a1_count = [0] * 1001
        
        for num in arr1:
            a1_count[num] += 1
        
        idx = 0
        for num in arr2:
            for i in range(a1_count[num]):
                arr1[idx] = num
                idx += 1
            a1_count[num] = 0
        
        for i in range(1001):
            for j in range(a1_count[i]):
                arr1[idx] = i
                idx += 1
        
        return arr1