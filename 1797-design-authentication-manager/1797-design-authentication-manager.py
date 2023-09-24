import heapq
class AuthenticationManager:

    def __init__(self, timeToLive: int):
        self.t_map = {}
        self.live = timeToLive

    def generate(self, tokenId: str, currentTime: int) -> None:
        self.t_map[tokenId] = currentTime + self.live
        #self.min_heap

    def renew(self, tokenId: str, currentTime: int) -> None:
        time = self.t_map.get(tokenId, 0)
        if time > currentTime:
            self.t_map[tokenId] = currentTime + self.live

    def countUnexpiredTokens(self, currentTime: int) -> int:
        res = 0
        for k, v in self.t_map.items():
            if v > currentTime:
                res += 1
        
        return res
  

# Your AuthenticationManager object will be instantiated and called as such:
# obj = AuthenticationManager(timeToLive)
# obj.generate(tokenId,currentTime)
# obj.renew(tokenId,currentTime)
# param_3 = obj.countUnexpiredTokens(currentTime)