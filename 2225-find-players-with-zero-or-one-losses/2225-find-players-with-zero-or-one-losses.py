from collections import defaultdict
class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
        players = defaultdict(Player)
        for match in matches:
            win, lose = match
            players[win].wins += 1
            players[win].matches += 1
            players[lose].losses += 1
            players[lose].matches += 1
        
        undef = []
        one_lost = []
        for player, prof in players.items():
            matches, wins, losses = prof.matches, prof.wins, prof.losses
            if matches > 0 and losses == 0:
                undef.append(player)
            
            if matches > 0 and losses == 1:
                one_lost.append(player)
        
        return [sorted(undef), sorted(one_lost)]

class Player:
    def __init__(self):
        self.matches = 0
        self.wins = 0
        self.losses = 0