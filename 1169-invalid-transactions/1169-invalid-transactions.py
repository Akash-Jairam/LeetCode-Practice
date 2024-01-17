from collections import defaultdict
class Solution:
    def invalidTransactions(self, transactions: List[str]) -> List[str]:
        t_map = defaultdict(list)
        invalid = []
        for t in transactions:
            txn = self.Transaction(t)
            t_map[txn.name].append(txn)
            
        for t in transactions:
            txn = self.Transaction(t)
            for t2 in t_map[txn.name]:
                if self.isInvalid(txn, t2):
                    invalid.append(t)
                    break
        
        return invalid
    def isInvalid(self, t1, t2):
        return t1.amt > 1000 or (t1.city != t2.city and abs(t1.time - t2.time) <= 60)
    
    class Transaction:
        def __init__(self, txn):
            self.txn = txn.split(",")
            self.time = int(self.txn[1])
            self.city = self.txn[3]
            self.amt = int(self.txn[2])
            self.name = self.txn[0]