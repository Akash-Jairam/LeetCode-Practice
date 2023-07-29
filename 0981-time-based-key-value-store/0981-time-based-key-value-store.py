from collections import defaultdict
class TimeMap:

    def __init__(self):
        self.t_map = defaultdict(list)
        

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.t_map[key].append((timestamp, value))

    def get(self, key: str, timestamp: int) -> str:
        keyL = self.t_map[key]
        l, r = 0, len(keyL) - 1
        res = None
        while l <= r:
            mid = l + (r - l) // 2
            time, v = keyL[mid]
            if time < timestamp:
                res = keyL[mid][1]
                l = mid + 1
            elif time > timestamp:
                r = mid - 1
            else:
                return v
        
        return "" if not res else res


# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)