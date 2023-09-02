class Solution:
    def winnerOfGame(self, colors: str) -> bool:
        # Keep track of number of valid moves
        # If both players play optimally, Alice will always win if she has more valid moves than Bob
        # Playing optimally means that you will always make the choice that will increase your chances of winning
        # Since Alice always goes first, she just needs to have more choices than Bob
        # If she has less than or equal choices, will run out of choices first and lose the game
        a_count, b_count = 0, 0
        
        for i in range(1, len(colors) - 1):
            if colors[i - 1] == colors[i] == colors[i+1]:
                if colors[i] == 'A':
                    a_count += 1
                else:
                    b_count += 1
        
        return a_count > b_count