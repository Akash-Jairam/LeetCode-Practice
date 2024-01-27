class TwoSum:

    def __init__(self):
        self.map = {}

    def add(self, number: int) -> None:
        self.map[number] = 1 + self.map.get(number, 0)

    def find(self, value: int) -> bool:
      
        for key in self.map.keys():
            diff = value - key
            if diff != key and diff in self.map:
                return True
            elif diff == key and self.map[diff] >= 2:
                return True
        
        
        return False


# Your TwoSum object will be instantiated and called as such:
# obj = TwoSum()
# obj.add(number)
# param_2 = obj.find(value)