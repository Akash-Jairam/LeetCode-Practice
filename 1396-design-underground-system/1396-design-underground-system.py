from collections import defaultdict
class UndergroundSystem:
    class trip:
        def __init__(self, start, uid, time):
            self.startSt = start
            self.uid = uid
            self.start_time = time
            self.endSt = ''
            self.timeTaken = None
            
    def __init__(self):
            self.completed = defaultdict(list)
            self.cust_map = {}

    def checkIn(self, id: int, stationName: str, t: int) -> None:
        self.cust_map[id] = self.trip(stationName, id, t)
        

    def checkOut(self, id: int, stationName: str, t: int) -> None:
        curr_trip = self.cust_map[id]
        curr_trip.endSt = stationName
        curr_trip.timeTaken = t - curr_trip.start_time
        del self.cust_map[id]
        self.completed[curr_trip.startSt].append(curr_trip)

    def getAverageTime(self, startStation: str, endStation: str) -> float:
        count, total = 0, 0
        for trip in self.completed[startStation]:
            if trip.endSt == endStation:
                count += 1
                total += trip.timeTaken
        
        return total / count if count > 0 else 0


# Your UndergroundSystem object will be instantiated and called as such:
# obj = UndergroundSystem()
# obj.checkIn(id,stationName,t)
# obj.checkOut(id,stationName,t)
# param_3 = obj.getAverageTime(startStation,endStation)