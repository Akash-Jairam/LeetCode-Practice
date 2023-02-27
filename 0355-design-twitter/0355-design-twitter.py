from collections import defaultdict
import heapq
class Twitter:

    def __init__(self):
        self.time = 0
        self.users = defaultdict(set)
        self.tweets = defaultdict(list)

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tweets[userId].append([self.time, tweetId])
        self.time -= 1
        
    def getNewsFeed(self, userId: int) -> List[int]:
        min_heap = []
        feed = []
        
        self.users[userId].add(userId)
        for following in self.users[userId]:
            ts = self.tweets[following]
            if ts:
                idx = len(ts) - 1
                time, tid = ts[idx]
                heapq.heappush(min_heap, [time, tid, idx, following])
            
        while min_heap and len(feed) < 10:
            time, tid, idx, following = heapq.heappop(min_heap)
            feed.append(tid)
            if idx:
                idx -= 1
                time, tid = self.tweets[following][idx]
                heapq.heappush(min_heap, [time, tid, idx, following])

        return feed
    
    def follow(self, followerId: int, followeeId: int) -> None:
        self.users[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followeeId in self.users[followerId]:
            self.users[followerId].remove(followeeId)


# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)