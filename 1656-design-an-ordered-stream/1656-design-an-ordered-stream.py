class OrderedStream:

    def __init__(self, n: int):
        self.key_map = {}
        self.max_key = n
        self.curr_key = 1

    def insert(self, idKey: int, value: str) -> List[str]:
        self.key_map[idKey] = value
        curr = []
        while self.curr_key <= self.max_key and self.curr_key in self.key_map:
            curr.append(self.key_map[self.curr_key])
            self.curr_key += 1
        
        return curr
            


# Your OrderedStream object will be instantiated and called as such:
# obj = OrderedStream(n)
# param_1 = obj.insert(idKey,value)