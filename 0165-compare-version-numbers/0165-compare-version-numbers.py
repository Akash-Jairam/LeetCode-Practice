class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        m, n = len(version1), len(version2)
        i, j = 0, 0
        res = 0
        v1N, v2N = 0, 0
        while i < m or j  < n:
            while i < m and version1[i] != '.':
                v1N = v1N * 10 + int(version1[i])
                i += 1
            i += 1
                
            while j < n and version2[j] != '.':
                v2N = v2N * 10 + int(version2[j])
                j += 1
            j += 1
            if v1N > v2N:
                return 1
            elif v1N < v2N:
                return -1
            
            v1N = 0
            v2N = 0
        return res