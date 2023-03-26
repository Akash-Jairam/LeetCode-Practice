class Solution:
    #https://leetcode.com/problems/longest-cycle-in-a-graph/discuss/2357631/DFS
    def longestCycle(self, e):
        res = -1
        memo = [(-1, -1) for i in range(len(e))]
        for i in range(len(e)):
            j = i
            dist = 0
            while j != -1:
                dist_i, from_i = memo[j]
                if dist_i == -1:
                    memo[j] = (dist, i)
                    dist += 1
                else:
                    if from_i == i:
                        res = max(res, dist - dist_i)
                    break
                j = e[j]
        return res
