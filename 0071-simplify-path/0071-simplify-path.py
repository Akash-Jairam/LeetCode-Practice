from collections import deque

class Solution:
    def simplifyPath(self, path: str) -> str:
        q = deque()
        # iterate over string and add path to q
        for in_path in path.split("/"):
            if not in_path or in_path == ".":
                continue
            elif in_path == "..":
                if q:
                    q.pop()
            else:
                q.append(in_path)
        
        # if the input case is : "/"
        if not q:
            return "/"
        
        R = "/"
        while q:
            R += q.popleft() + "/"
        return R[:-1]
