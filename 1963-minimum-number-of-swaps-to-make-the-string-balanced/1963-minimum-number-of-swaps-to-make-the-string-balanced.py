class Solution:
    def minSwaps(self, s: str) -> int:
        num_left, num_right = 0, 0
        left, right = 0, len(s) - 1
        swaps = 0
        
        while left < right:
            if s[left] == '[':
                num_left += 1
            elif num_left:
                num_left -= 1
            else:
                while right > left:
                    if s[right] == ']':
                        num_right += 1
                    elif num_right:
                        num_right -= 1
                    else:
                        num_left += 1
                        num_right += 1
                        right -= 1
                        swaps += 1
                        break
                    right -= 1
            left += 1
        
        return swaps