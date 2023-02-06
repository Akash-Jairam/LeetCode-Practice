class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        s_nums = [str(num) for num in nums]
        
        def compare(n1, n2):
            if n1 + n2 > n2 + n1:
                return -1
            else:
                return 1
        
        s_nums = sorted(s_nums, key=cmp_to_key(compare))
        return str(int(''.join(s_nums)))