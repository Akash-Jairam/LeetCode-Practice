class MinStack:
    class Node:
        def __init__(self, val, minimum):
            self.val = val
            self.min = minimum
            
    def __init__(self):
        self.stack = []

    def push(self, val: int) -> None:
        min_cand = self.stack[-1].min if self.stack else float('inf')
        self.stack.append(self.Node(val, min(val, min_cand)))

    def pop(self) -> None:
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1].val

    def getMin(self) -> int:
        return self.stack[-1].min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()