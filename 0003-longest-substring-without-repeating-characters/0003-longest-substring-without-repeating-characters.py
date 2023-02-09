class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        #Use a sliding window
        #Add chars to the set
        #If we encounter a char that is in the set
        #Remove left and Increment left pointer until the dupe is removed from the set
        #Add the  char to set and take length/update res
        
        l, c_set = 0, set()
        res = 0
        
        for c in s:
            while c in c_set:
                c_set.remove(s[l])
                l += 1
            
            c_set.add(c)
            res = max(res, len(c_set))
        
        return res