class Solution:
    def reachingPoints(self, sx: int, sy: int, tx: int, ty: int) -> bool:
        while tx > sx and ty > sy:
            if tx > ty:
                tx %= ty
            else:
                ty %= tx
        
        return tx == sx and sy <= ty and (ty - sy) % tx == 0 or \
    ty == sy and sx <= tx and (tx - sx) % ty == 0