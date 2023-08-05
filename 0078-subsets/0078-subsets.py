class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        '''
            We have to use backtracking starting a index 0, using a list to store the numbers
            If index is greater than len(nums), we return
            Otherwise, we append a copy of the curr list to our result array
            We then iterate from the current index to the end of nums
                Here we append the value at the current index to our curr list
                We make a recursive call starting at the position after the current index
                Then we pop the last index of our current list
             
        '''
        res = []
        self.backtrack(res, 0, nums, [])
        return res
    
    def backtrack(self, res, i, nums, curr):
        
        if i > len(nums):
            return
        
        res.append(list(curr))
        for j in range(i, len(nums)):
            curr.append(nums[j])
            self.backtrack(res, j + 1, nums, curr)
            curr.pop()
        
        
        
    