class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        length, count = len(flowerbed), 0
        for i in range(length):
            if not flowerbed[i]: 
                left_flower = True if i > 0 and flowerbed[i-1] else False
                right_flower = True if i < length - 1 and flowerbed[i+1] else False
                if not left_flower and not right_flower:
                    flowerbed[i] = 1
                    count += 1
        
        return count >= n