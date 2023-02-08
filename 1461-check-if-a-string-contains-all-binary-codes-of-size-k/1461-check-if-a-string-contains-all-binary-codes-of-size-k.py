class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        # Create a set and iterate through s to get all possible substrings of k length
        # Check to see if the lenght of the set is equal to the total # binary codes of side k
        b_set = set()
        
        for i in range(len(s) - k + 1):
            b_set.add(s[i:i+k])
            
        return len(b_set) == 2 ** k