class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        left, right = 0, len(people) - 1
        res = 0
        
        while left <= right:
            curr = people[left] + people[right] if left != right else people[left]
            
            if curr <= limit:
                left += 1
                right -= 1
            else:
                right -= 1
            
            res += 1
        
        return res