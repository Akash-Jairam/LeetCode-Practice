class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        pos = []
        neg = []
        res = []
        for num in nums:
            if num >= 0:
                pos.append(num)
            else:
                neg.append(num)
        
        for n1, n2 in zip(pos, neg):
            res.append(n1)
            res.append(n2)
        
        return res