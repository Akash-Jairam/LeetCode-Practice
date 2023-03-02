class Solution:
    def compress(self, chars: List[str]) -> int:
        index, count = 0, 1
        curr = chars[0]
        def writeCount(curr_count, idx):
            curr_count = str(curr_count)
            for c in curr_count:
                chars[idx] = c
                idx += 1
            
            return idx
        
        
        for i in range(1, len(chars)):
            if chars[i] == chars[i-1]:
                count += 1
            else:
                chars[index] = curr
                if count > 1:
                    index = writeCount(count, index+1)
                else:
                    index += 1
                curr = chars[i]
                count = 1 
        
        chars[index] = curr
        return writeCount(count, index+1)  if count > 1 else index + 1