class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        pair = [(p, s) for p, s in zip(position, speed)]
        
        pair.sort(reverse = True)
        stack = []
        
        for p, s in pair:
            # Calculate time needed to get to get to target
            # Time = Distance / Speed
            stack.append((target - p) / s)
            # If the car behind the current car can take less time to 
            # Get to the target, then it will catch up
            if len(stack) >= 2 and stack[-1] <= stack[-2]:
                stack.pop()
                
        return len(stack)