from collections import deque
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        q = deque([beginWord])
        
        def isAdj(w, cand):
            diff = 0
            for i in range(len(w)):
                if w[i] != cand[i]:
                    diff += 1
                
            return diff == 1
        
        numSteps = 0
        visited = set()
        while q:
            size = len(q)
            numSteps += 1
            for _ in range(size):
                curr = q.popleft()
                
                for word in wordList:
                    if word not in visited and isAdj(curr, word):
                        visited.add(word)
                        if word == endWord:
                            return numSteps + 1
                        q.append(word)

        
        return 0