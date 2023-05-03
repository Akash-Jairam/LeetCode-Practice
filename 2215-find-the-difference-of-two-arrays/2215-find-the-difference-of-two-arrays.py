class Solution:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        n1, n2 = set(nums1), set(nums2)
        res = [set() for i in range(2)]
        i, j, m, n = 0, 0, len(nums1), len(nums2)
        
        while i < m or j < n:
            if i < m:
                if nums1[i] not in n2:
                    res[0].add(nums1[i])
                i += 1
            
            if j < n:
                if nums2[j] not in n1:
                    res[1].add(nums2[j])
                j += 1
        
        return [list(s) for s in res]
                    
                
        
        
        
        
        
        