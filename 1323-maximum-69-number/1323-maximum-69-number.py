class Solution:
    def maximum69Number (self, num: int) -> int:
        num_copy = num
        index_first_six = -1
        curr_index = 0
        while num_copy > 0:
            if num_copy % 10 == 6:
                index_first_six = curr_index
            curr_index += 1
            num_copy //= 10
        
        if index_first_six > -1:
            to_add = int (3 * (math.pow(10, index_first_six)))
            return num + to_add
        
        return num
        