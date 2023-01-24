class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        stack, greater_map, res = [], {}, []
        
        for num in nums2:
            while stack and stack[-1] <= num:
                greater_map[stack.pop()] = num
            stack.append(num)
        
        for num in nums1:
            res.append(greater_map.get(num, -1))
        
        return res
            