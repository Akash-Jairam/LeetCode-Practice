class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        x, y = 0, 0 
        directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        pos = 0
        
        for i in instructions:
            if i == 'R':
                pos = (pos + 1) % 4
            elif i == 'L':
                pos = (pos + 3) % 4
            else:
                x = x + directions[pos][0]
                y = y + directions[pos][1]
        
        return (x == 0 and y == 0) or pos != 0