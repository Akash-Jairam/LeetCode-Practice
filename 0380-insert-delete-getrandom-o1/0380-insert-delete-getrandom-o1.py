import random

class RandomizedSet:

    def __init__(self):
        self.store = []  # To store the elements
        self.store_s = {}  # To store the index of each element in the store list

    def insert(self, val: int) -> bool:
        if val not in self.store_s:
            self.store.append(val)
            self.store_s[val] = len(self.store) - 1
            return True
        return False

    def remove(self, val: int) -> bool:
        if val in self.store_s:
            idx = self.store_s[val]
            last_element = self.store[-1]

            # Update the index of the last element in the store_s dictionary
            self.store_s[last_element] = idx

            # Swap the element to be removed with the last element and pop it
            self.store[idx], self.store[-1] = self.store[-1], self.store[idx]
            self.store.pop()

            # Remove the entry for the removed element from store_s
            del self.store_s[val]

            return True
        return False

    def getRandom(self) -> int:
        return random.choice(self.store)
