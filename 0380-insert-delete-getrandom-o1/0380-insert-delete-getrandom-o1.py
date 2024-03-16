import random
class RandomizedSet:

    def __init__(self):
        self.store = []
        self.i_map = {}

    def insert(self, val: int) -> bool:
        curr = self.i_map
        if val in self.i_map:
            return False
        
        self.store.append(val)
        self.i_map[val] = len(self.store) - 1
        return True

    def remove(self, val: int) -> bool:
        curr = self.i_map
        if val in self.i_map:
            if len(self.store) > 1:
                valIdx = self.i_map[val]
                lastValue = self.store[-1]
                self.i_map[lastValue] = valIdx

                self.store[valIdx], self.store[-1] = self.store[-1], self.store[valIdx]
                self.store.pop()
                del self.i_map[val]
            else:
                self.store = []
                self.i_map = {}
            return True
        
        return False
        

    def getRandom(self) -> int:
        return random.choice(self.store)


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()