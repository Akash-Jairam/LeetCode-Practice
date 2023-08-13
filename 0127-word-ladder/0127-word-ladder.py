from collections import defaultdict, deque
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0
        
        neigh = defaultdict(list)
        
        for word in wordList:
            for j in range(len(word)):
                pattern = word[:j] + "*" + word[j+1:]
                neigh[pattern].append(word)
        
        visited = set([beginWord])
        q = deque([beginWord])
        steps = 1
        while q:
            size = len(q)
            for _ in range(size):
                curr = q.popleft()
                if curr == endWord:
                    return steps
                for j in range(len(curr)):
                    pattern = curr[:j] + "*" + curr[j+1:]
                    for word in neigh[pattern]:
                        if word not in visited:
                            visited.add(word)
                            q.append(word)
            steps += 1
        
        return 0