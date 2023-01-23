class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        length = len(flowerbed)
        for i in range(length):
            if flowerbed[i]:
                continue
            left_flower = True if i > 0 and flowerbed[i-1] else False
            right_flower = True if i < length - 1 and flowerbed[i+1] else False
            if not left_flower and not right_flower:
                flowerbed[i] = 1
                n -= 1
        
        return n <= 0