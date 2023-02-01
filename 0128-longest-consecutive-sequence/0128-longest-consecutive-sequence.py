class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        n_set = set()
        max_seq = 0
        
        for num in nums:
            n_set.add(num)
            
        for num in nums:
            temp = num
            count = 1
            if temp - 1 not in n_set:
                while n_set and temp + 1 in n_set:
                    temp += 1
                    count += 1
            
            max_seq = max(max_seq, count)
           
                
        return max_seq