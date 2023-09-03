class Solution:
    def reachingPoints(self, sx: int, sy: int, tx: int, ty: int) -> bool:
        while tx > sx and ty > sy:
            if tx > ty:
                tx %= ty
            else:
                ty %= tx
        
        return sx == tx and sy <= ty and (sy - ty) % tx == 0 or \
               sy == ty and sx <= tx and (sx - tx) % ty == 0