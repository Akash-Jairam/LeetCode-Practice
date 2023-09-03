class Solution:
    def originalDigits(self, s: str) -> str:
        from collections import Counter
        counter = Counter(s)
        res=[0 for _ in range(10)] 
        # map, get even count
        res[0] = counter['z']
        res[2] = counter['w']
        res[4] = counter['u']
        res[6] = counter['x']
        res[8] = counter['g']
        # get odd count
        res[1] = counter['o'] - (res[0]+res[2]+res[4])
        res[3] = counter['r'] - (res[0] + res[4])
        res[5] = counter['f'] - res[4]
        res[7] = counter['s'] - res[6]
        res[9] = counter['i'] - (res[5]+res[6]+res[8])

        return ''.join(str(index)*freq for index,freq in enumerate(res))