class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        if len(arr) == 1:
            return [-1]
        
        max_num = -1
        
        for i, n in reversed(list(enumerate(arr))):
           temp = arr[i]
           arr[i] = max_num

           max_num = max(temp, arr[i])
        
        arr[len(arr) - 1] = -1
        return arr
        