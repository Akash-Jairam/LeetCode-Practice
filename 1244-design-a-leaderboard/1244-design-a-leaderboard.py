import heapq
class Leaderboard:
    def __init__(self):
        self.players = {}

    def addScore(self, playerId: int, score: int) -> None:
        if playerId not in self.players:
            self.players[playerId] = 0
        self.players[playerId] += score

    def top(self, K: int) -> int:
        min_heap = []
        top_k = 0
        for score in self.players.values():
            top_k += score
            heapq.heappush(min_heap, score)
            if len(min_heap) > K:
                top_k -= heapq.heappop(min_heap)
        return sum(min_heap)
    def reset(self, playerId: int) -> None:
        self.players[playerId] = 0


# Your Leaderboard object will be instantiated and called as such:
# obj = Leaderboard()
# obj.addScore(playerId,score)
# param_2 = obj.top(K)
# obj.reset(playerId)