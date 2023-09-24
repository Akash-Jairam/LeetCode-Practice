class AuthenticationManager:

    def __init__(self, timeToLive: int):
        self.ttl = timeToLive
        self.t_map = {}
        

    def clean(self, currentTime):
        to_remove = []
        for tId, time in self.t_map.items():
            if time <= currentTime:
                to_remove.append(tId)
        
        for tId in to_remove:
            del self.t_map[tId]
        
            
    def generate(self, tokenId: str, currentTime: int) -> None:
        self.t_map[tokenId] = currentTime + self.ttl

    def renew(self, tokenId: str, currentTime: int) -> None:
        self.clean(currentTime)
        if tokenId in self.t_map:
            self.t_map[tokenId] = currentTime + self.ttl

    def countUnexpiredTokens(self, currentTime: int) -> int:
        self.clean(currentTime)
        return len(self.t_map)


# Your AuthenticationManager object will be instantiated and called as such:
# obj = AuthenticationManager(timeToLive)
# obj.generate(tokenId,currentTime)
# obj.renew(tokenId,currentTime)
# param_3 = obj.countUnexpiredTokens(currentTime)