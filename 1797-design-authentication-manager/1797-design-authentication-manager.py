class AuthenticationManager:

    def __init__(self, timeToLive: int):
        self.ttl = timeToLive
        self.tokens = {}

    def generate(self, tokenId: str, currentTime: int) -> None:
        self.tokens[tokenId] = currentTime  + self.ttl

    def renew(self, tokenId: str, currentTime: int) -> None:
        expTime = self.tokens.get(tokenId, -1)
        if expTime > currentTime:
            self.tokens[tokenId] = currentTime + self.ttl
            
    def countUnexpiredTokens(self, currentTime: int) -> int:
        unExpired = {}
        for tId, exp in self.tokens.items():
            if exp > currentTime:
                unExpired[tId] = exp
        
        self.tokens = unExpired
        return len(self.tokens.keys())


# Your AuthenticationManager object will be instantiated and called as such:
# obj = AuthenticationManager(timeToLive)
# obj.generate(tokenId,currentTime)
# obj.renew(tokenId,currentTime)
# param_3 = obj.countUnexpiredTokens(currentTime)