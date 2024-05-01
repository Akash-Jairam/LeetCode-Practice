class Solution:
    def reversePrefix(self, word: str, ch: str) -> str:
        w_arr = list(word)
        i = 0
        while i < len(word) and word[i] != ch:
            i += 1
        
        if i == len(word):
            return word
        l, r = 0, i
        while l < r:
            w_arr[l], w_arr[r] = w_arr[r], w_arr[l]
            l += 1
            r -= 1
        
        return ''.join(w_arr)