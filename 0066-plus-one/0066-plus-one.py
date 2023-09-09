class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        i = len(digits) - 1
        rem = 1
        while i >= 0:
            newTotal = digits[i] + rem
            digits[i] = newTotal % 10
            rem = newTotal // 10
            i -= 1
        
        return digits if rem == 0 else [1] + digits