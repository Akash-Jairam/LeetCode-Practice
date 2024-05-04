class Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        age_map = {}
        res = 0
        for a in ages:
            age_map[a] = 1 + age_map.get(a, 0)
        
        for age1 in age_map.keys():
            for age2 in age_map.keys():
                if self.request(age1, age2):
                    if age1 != age2:
                        res = res + age_map[age1] * age_map[age2]
                    else:
                        res = res + age_map[age1] * (age_map[age2] - 1)
                    
        
        return res
    def request(self, a, b):
        return not( b <= (0.5 * a + 7) or b > a or (b > 100 and a < 100))