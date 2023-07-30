class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        # Keep two pointers to the arrays, A and B where A will point to the smaller array
        # Find the midpt which is the total length of the arrays // 2
        # Perform binary search on the smaller array
        # Get the relative index by subtracting the midpt from the binary search from the half - 2
        # Aleft = A[mid], Aright = A[mid + 1]
        # Bleft = B[relative],  Bright = B[relative + 1]
        # if any of these indices are out of bounds set them to float(-inf) if they are out of bounds on the left, else float(inf)
        # If Aleft <= Bright and Bleft <= Aright, we have found the median point of the sorted arrays
        # Return max(Aleft, Bleft) + min(Aright, Bright) if the total is even
        # Else min(Aright, Bright)
        # If the left values aren't less than the rights
        # Set left to i + 1 if Aleft < Bright 
        # Or set right to i - 1 otherwise
        # This will help us to better find the correct position in the B array
        A, B = nums1, nums2
        total = len(nums1) + len(nums2)
        half = total // 2
        
        if len(A) > len(B):
            A, B = B, A
            
        l, r = 0, len(A) - 1
        
        while True:
            i = l + (r - l) // 2
            j = half - i - 2
            
            Aleft = A[i] if i >= 0 else float('-inf') 
            Aright = A[i+1] if i + 1 < len(A) else float('inf')
            Bleft = B[j] if j >= 0 else float('-inf')
            Bright = B[j+1] if j + 1 < len(B) else float('inf')
            
            if Aleft <= Bright and Bleft <= Aright:
                if total % 2 == 1:
                    return min(Aright, Bright)
                else:
                    return (max(Aleft, Bleft) + min(Aright, Bright)) / 2
            elif Aleft < Bright:
                l = i + 1
            else:
                r = i - 1
                
            
        
        