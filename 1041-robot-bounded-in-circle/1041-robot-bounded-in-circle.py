class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        x = y = 0
        direction = 0
        
        moves = {0:[0, 1], 1:[1, 0], 2:[0, -1], 3: [-1, 0]}
        
        for i in instructions:
            if i == 'L':
                direction = (direction + 3) % 4
            elif i == 'R':
                direction = (direction + 1) % 4
            else:
                x = x + moves[direction][0]
                y = y + moves[direction][1]
            
        return (x == 0 and y == 0) or direction != 0