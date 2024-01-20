class UndergroundSystem:

    def __init__(self):
        self.cust_map = {}
        self.stat_map = {}

    def checkIn(self, id: int, stationName: str, t: int) -> None:
        self.cust_map[id] = (stationName, t)

    def checkOut(self, id: int, stationName: str, t: int) -> None:
        start, start_t = self.cust_map[id]
        del self.cust_map[id]
        if (start, stationName) not in self.stat_map:
            self.stat_map[(start, stationName)] = []
        self.stat_map[(start, stationName)].append(t - start_t)
        

    def getAverageTime(self, startStation: str, endStation: str) -> float:
        total = 0
        count = 0
        for t in self.stat_map[(startStation, endStation)]:
            total += t
            count += 1
        
        return total / count if count else 0


# Your UndergroundSystem object will be instantiated and called as such:
# obj = UndergroundSystem()
# obj.checkIn(id,stationName,t)
# obj.checkOut(id,stationName,t)
# param_3 = obj.getAverageTime(startStation,endStation)