class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        if n == 0:
            return True
        
        for i in range(len(flowerbed)):
            if flowerbed[i]:
                continue
            left = 0
            right = 0
            if i > 0 and flowerbed[i-1] == 1:
                left = 1
            
            if i < len(flowerbed) - 1 and flowerbed[i+1] == 1:
                right = 1
                
            if left == 0 and right == 0:
                flowerbed[i] = 1
                n -= 1
                if n == 0:
                    return True
        
        return False
                
        
        