class Solution:
    def minSwaps(self, s: str) -> int:
        leftstack, rightstack = [], []
        left, right = 0, len(s) - 1
        swaps = 0
        
        while left < right:
            if s[left] == '[':
                leftstack.append(s[left])
            elif leftstack:
                leftstack.pop()
            else:
                while right > left:
                    if s[right] == ']':
                        rightstack.append(s[right])
                    elif rightstack:
                        rightstack.pop()
                    else:
                        leftstack.append(s[left])
                        rightstack.append(s[right])
                        right -= 1
                        swaps += 1
                        break
                    right -= 1
            left += 1
        
        return swaps