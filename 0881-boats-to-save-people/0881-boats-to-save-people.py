class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        l, r = 0, len(people) - 1
        res = 0
        while l <= r:
            curr = people[l] + people[r] if l != r else people[l]
            
            if curr <= limit:
                l += 1
                r -= 1
            else:
                r -= 1
            res += 1
            
        return res