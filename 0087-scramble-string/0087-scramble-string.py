class Solution:
    def isScramble(self, s1: str, s2: str) -> bool:
        def recur(s1, s2):
            if s1 == s2:
                return True
            if Counter(s1) != Counter(s2):
                return False
            if (s1, s2) in dp:
                return dp[(s1, s2)]
            dp[(s1, s2)] = False
            for i in range(1, len(s1)):
                if recur(s1[:i], s2[:i]) and recur(s1[i:], s2[i:]):
                    dp[(s1, s2)] = True
                    return True
                if recur(s1[:i], s2[-i:]) and recur(s1[i:], s2[:-i]):
                    dp[(s1, s2)] = True
                    return True
            return dp[(s1, s2)]
        
        dp = dict()
        return recur(s1, s2)