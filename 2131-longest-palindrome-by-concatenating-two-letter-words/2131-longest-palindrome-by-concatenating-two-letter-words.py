class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        res = 0
        w_map = defaultdict(int)
        num_pals = 0
        
        for word in words:
            if word[0] == word[1]:
                if word in w_map and w_map[word] > 0:
                    w_map[word] -= 1
                    res += 4
                    num_pals -= 1
                else:
                    w_map[word] += 1
                    num_pals += 1
            else:
                reversed_word = word[::-1]
                if reversed_word in w_map and w_map[reversed_word] > 0:
                    w_map[reversed_word] -= 1
                    res += 4
                else:
                    w_map[word] += 1
        
        if num_pals > 0:
            res += 2
            
        
        return res
                
                
        