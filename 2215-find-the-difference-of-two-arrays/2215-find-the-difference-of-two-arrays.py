class Solution:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        n1, n2 = set(nums1), set(nums2)        
        
        return [[num for num in n1 - n2], [num for num in n2 - n1]]
                    
                
        
        
        
        
        
        