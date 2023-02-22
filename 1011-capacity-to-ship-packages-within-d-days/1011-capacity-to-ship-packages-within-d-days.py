class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        def need_days(cap):
            days = 1
            running_sum = 0
            
            for w in weights:
                running_sum += w
                if running_sum > cap:
                    running_sum = w
                    days += 1
            
            return days
        
        left, right = max(weights), sum(weights)
        
        while left < right:
            mid = left + (right - left) // 2
            if need_days(mid) > days:
                left = mid + 1
            else: 
                right = mid
        
        return left
            