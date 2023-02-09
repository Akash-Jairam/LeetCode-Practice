class Solution:
    def distinctNames(self, ideas: List[str]) -> int:
        # Create an array with a set for each letter in the alphabet
        idea_set = [set() for _ in range(26)]
        res = 0
        
        # Iterate through ideas and add the suffix of each idea to the corresponding set
        for i in ideas:
            idea_set[ord(i[0]) - ord('a')].add(i[1:])
        
        
        # Iterate through each set and iterate through each other set
        # Get the unique suffixes in both sets
        # Add 2 * the length of s1 - unique suffixes * length of s2 - unique suffixes
        # We need only the unique suffixes and each suffix can be paired in two ways
        for i in range(25):
            s1 = idea_set[i]
            for j in range(i+1, 26):
                s2 = idea_set[j]
                
                uset_size =  len(s1.union(s2))
                res += 2 * (len(s1) - uset_size) * (len(s2) - uset_size)
                
        return res