class Solution:
    def winnerOfGame(self, colors: str) -> bool:
        # Keep track of # of valid solutions
        # Person with the greater number wins
        count_A, count_B = 0,0
        n = len(colors)
        
        for i in range(1, n - 1):
            if colors[i-1] == colors[i] == colors[i+1]:
                if colors[i] == 'A':
                    count_A += 1
                else:
                    count_B += 1
        
        return count_A > count_B