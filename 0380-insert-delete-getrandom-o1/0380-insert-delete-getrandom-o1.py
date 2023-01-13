class RandomizedSet:

    def __init__(self):
        self.num_map, self.num_list = {}, []
        

    def insert(self, val: int) -> bool:
        if val in self.num_map:
            return False
        
        self.num_list.append(val)
        self.num_map[val] = len(self.num_list) - 1
        return True
        

    def remove(self, val: int) -> bool:
        if val in self.num_map:
            last_element, idx = self.num_list[-1], self.num_map[val]
            self.num_list[idx], self.num_map[last_element] = last_element,idx
            del self.num_map[val]
            self.num_list.pop()
            return True
        
        return False

    def getRandom(self) -> int:
        return random.choice(self.num_list)
        


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()