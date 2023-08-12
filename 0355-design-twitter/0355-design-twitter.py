from collections import defaultdict
import heapq

class Twitter:

    def __init__(self):
        self.following = defaultdict(set)
        self.tweets = defaultdict(list)
        self.time = 0

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.time -= 1
        self.tweets[userId].append((self.time, tweetId))

    def getNewsFeed(self, userId: int) -> List[int]:
        self.following[userId].add(userId)
        res = []
        max_heap = []
        for user in self.following[userId]:
            if len(self.tweets[user]) > 0:
                idx = len(self.tweets[user]) - 1
                time, tId = self.tweets[user][idx]
                heapq.heappush(max_heap, [time, tId, user, idx - 1])
        
        while max_heap and len(res) < 10:
            time, tId, user, idx = heapq.heappop(max_heap)
            res.append(tId)
            
            if idx >= 0:
                time, tId = self.tweets[user][idx]
                heapq.heappush(max_heap, [time, tId, user, idx - 1])
        
        return res

    def follow(self, followerId: int, followeeId: int) -> None:
        self.following[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followeeId in self.following[followerId]:
            self.following[followerId].remove(followeeId)


# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)