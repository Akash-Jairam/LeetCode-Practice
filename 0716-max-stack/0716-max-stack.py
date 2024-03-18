from sortedcontainers import SortedList
class MaxStack:

    def __init__(self):
        self.order = SortedList()
        self.values = SortedList()
        self.count = 0
    def push(self, x: int) -> None:
        
        self.order.add((self.count, x))
        self.values.add((x, self.count))
        self.count += 1

    def pop(self) -> int:
        count, val = self.order.pop()
        self.values.remove((val, count))
        return val

    def top(self) -> int:
        return self.order[-1][1]

    def peekMax(self) -> int:
        return self.values[-1][0]

    def popMax(self) -> int:
        val, count = self.values.pop()
        self.order.remove((count, val))
        return val


# Your MaxStack object will be instantiated and called as such:
# obj = MaxStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.peekMax()
# param_5 = obj.popMax()