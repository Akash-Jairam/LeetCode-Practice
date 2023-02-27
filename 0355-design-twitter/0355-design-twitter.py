class Twitter:
    class Tweet:
        def __init__(self, userId, tweetId):
            self.userId = userId
            self.tweetId = tweetId
    
    class User:
        def __init__(self, userId):
            self.userId = userId
            self.following = set()
        
    def __init__(self):
        self.users = {}
        self.tweets = []

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.addUser(userId)
        self.tweets.append(self.Tweet(userId, tweetId))

    def getNewsFeed(self, userId: int) -> List[int]:
        idx = len(self.tweets) - 1
        feed = []
        
        while idx >= 0 and len(feed) < 10:
            currId = self.tweets[idx].userId
            if currId in self.users[userId].following or currId == userId:
                feed.append(self.tweets[idx].tweetId)
            idx -= 1
        
        return feed

    def follow(self, followerId: int, followeeId: int) -> None:
        self.addUser(followerId)
        self.addUser(followeeId)
        
            
        self.users[followerId].following.add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        followingList = self.users[followerId].following
        if followeeId in followingList:
            followingList.remove(followeeId)
        
    def addUser(self, uid):
        if uid not in self.users:
            self.users[uid] = self.User(uid)


# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)