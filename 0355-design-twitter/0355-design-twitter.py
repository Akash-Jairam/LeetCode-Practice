from collections import defaultdict
import heapq
class Twitter:

    def __init__(self):
        self.following = defaultdict(set)
        self.tweets = defaultdict(list)
        self.time = 0
        

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.time -= 1
        self.tweets[userId].append([self.time, tweetId])

    def getNewsFeed(self, userId: int) -> List[int]:
        max_heap = []
        res = []
        
        self.following[userId].add(userId)
        for followee in self.following[userId]:
            if followee in self.tweets:
                index = len(self.tweets[followee]) - 1
                count, tweetId = self.tweets[followee][index]
                heapq.heappush(max_heap, [count, tweetId, followee, index - 1])
        
        while max_heap and len(res) < 10:
            count, tweetId, followeeId, index = heapq.heappop(max_heap)
            res.append(tweetId)
            if index >= 0:
                count, tweetId = self.tweets[followeeId][index]
                heapq.heappush(max_heap, [count, tweetId, followeeId, index - 1])
        
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