class Solution:
    def unhappyFriends(self, n: int, preferences: List[List[int]], pairs: List[List[int]]) -> int:
        preferred = {}
        unhappy = 0
        for p1, p2 in pairs:
            self.pop_preferred(preferences, p1, p2, preferred)
            self.pop_preferred(preferences, p2, p1, preferred)
        
        for x in preferred:
            for pref in preferred[x]:
                if x in preferred[pref]:
                    unhappy += 1
                    break
        
        return unhappy
    
    def pop_preferred(self, preferences, x, y, preferred):
        preferred[x] = set()
        for num in preferences[x]:
            if num == y:
                break
                
            preferred[x].add(num)
