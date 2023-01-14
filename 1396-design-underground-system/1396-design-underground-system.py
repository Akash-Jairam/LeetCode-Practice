class UndergroundSystem:
    class trip:
        def __init__(self, startStation, startTime):
            self.startStation = startStation
            self.startTime = startTime
            self.endStation = None
            self.endTime = None
            self.timeTaken = None
        
        def find_time_taken(self):
            self.timeTaken = self.endTime - self.startTime
            
    def __init__(self):
        self.customer = {}
        self.completed = {}

    def checkIn(self, id: int, stationName: str, t: int) -> None:
        self.customer[id] = self.trip(stationName, t)
        

    def checkOut(self, id: int, stationName: str, t: int) -> None:
        if id in self.customer:
            curr_trip = self.customer[id]
            curr_trip.endStation = stationName
            curr_trip.endTime = t
            curr_trip.find_time_taken()
            startStation = curr_trip.startStation
            if startStation not in self.completed:
                self.completed[startStation] = []
            self.completed[startStation].append(curr_trip)
        

    def getAverageTime(self, startStation: str, endStation: str) -> float:
        if startStation in self.completed:
            count, curr_sum = 0, 0
            for trip in self.completed[startStation]:
                if trip.endStation == endStation:
                    curr_sum += trip.timeTaken
                    count += 1
            
            return curr_sum / count
        
        return -1


# Your UndergroundSystem object will be instantiated and called as such:
# obj = UndergroundSystem()
# obj.checkIn(id,stationName,t)
# obj.checkOut(id,stationName,t)
# param_3 = obj.getAverageTime(startStation,endStation)