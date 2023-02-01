class OrderedStream:

    def __init__(self, n: int):
        self.stream = [""] * (n+1)
        self.idx = 1

    def insert(self, idKey: int, value: str) -> List[str]:
        self.stream[idKey] = value
        curr = []
        while self.idx < len(self.stream) and self.stream[self.idx]:
            curr.append(self.stream[self.idx])
            self.idx += 1
        
        return curr


# Your OrderedStream object will be instantiated and called as such:
# obj = OrderedStream(n)
# param_1 = obj.insert(idKey,value)