class Solution(object):
    def wonderfulSubstrings(self, word):
        """
        :type word: str
        :rtype: int
        """
        # Dictionary to store the frequency of parity configurations
        freq = {}
        
        # Initially, we have no characters, which is an even configuration for all characters (all zeroes)
        # The representation is a tuple of 10 boolean values indicating even (True) or odd (False)
        current_parity = tuple(True for _ in range(10))
        freq[current_parity] = 1
        
        # Array to count occurrences of each character
        count = [0] * 10
        res = 0
        
        # Iterate over each character in the string
        for c in word:
            index = ord(c) - 97
            
            # Update count for this character
            count[index] += 1
            
            # Update parity information for this character
            current_parity = tuple(count[i] % 2 == 0 for i in range(10))
            
            # Add the number of times we have seen this parity configuration (substrings with all even counts)
            if current_parity in freq:
                res += freq[current_parity]
                freq[current_parity] += 1
            else:
                freq[current_parity] = 1
            
            # Check configurations with exactly one odd character count
            for odd_index in range(10):
                # Flip the parity of the current character
                modified_parity = list(current_parity)
                modified_parity[odd_index] = not modified_parity[odd_index]
                modified_parity = tuple(modified_parity)
                
                # Add the number of times this modified parity configuration has been seen
                if modified_parity in freq:
                    res += freq[modified_parity]
        
        return res
