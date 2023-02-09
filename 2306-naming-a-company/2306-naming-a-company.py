class Solution:
    def distinctNames(self, ideas: List[str]) -> int:
        idea_set = [set() for _ in range(26)]
        res = 0
        for i in ideas:
            idea_set[ord(i[0]) - ord('a')].add(i[1:])
        
        
        for i in range(25):
            s1 = idea_set[i]
            for j in range(i+1, 26):
                s2 = idea_set[j]
                
                uset_size =  len(s1.union(s2))
                res += 2 * (len(s1) - uset_size) * (len(s2) - uset_size)
                
        return res