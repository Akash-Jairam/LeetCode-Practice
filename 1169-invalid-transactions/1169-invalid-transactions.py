from collections import defaultdict
class Solution:
    def invalidTransactions(self, transactions: List[str]) -> List[str]:
        class transaction:
            def __init__(self, s):
                split = s.split(",")
                self.name = split[0]
                self.time = int(split[1])
                self.cost =int(split[2])
                self.loc = split[3]

            def isInvalid(self, place, time):
                return self.cost > 1000 or (self.loc != place and abs(self.time - time) <= 60)
        
        p_map = defaultdict(list)
        res = []
        for trans in transactions:
            t = transaction(trans)
            p_map[t.name].append(t)
        
        
        for trans in transactions:
            t = transaction(trans)
            for item in p_map[t.name]:
                if t.isInvalid(item.loc, item.time):
                    res.append(trans)
                    break
                    
        return res