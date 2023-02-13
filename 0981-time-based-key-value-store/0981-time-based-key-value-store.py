from collections import defaultdict
class TimeMap:

    def __init__(self):
        self.time_map = defaultdict(list)

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.time_map[key].append((value, timestamp))

    def get(self, key: str, timestamp: int) -> str:
        times = self.time_map[key]
        l,r = 0, len(times) - 1
        res = ""
        
        while l <= r:
            mid = l + (r-l) // 2
            midTime = times[mid][1]
            if midTime <= timestamp:
                l = mid + 1
                res = times[mid][0]
            else:
                r = mid - 1
                
        
        return res


# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)