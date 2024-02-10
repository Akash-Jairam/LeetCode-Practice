class Solution:
    def validWordAbbreviation(self, word: str, abbr: str) -> bool:
        if len(abbr) > len(word):
            return False
        i, j = 0, 0
        curr_num = 0
        while i < len(abbr):
            if(abbr[i].isdigit()):
                if not curr_num and abbr[i] == '0':
                    return False
                curr_num = curr_num * 10 + int(abbr[i])
            elif curr_num:
                j = j + curr_num
                
                curr_num = 0
            
            if j >= len(word):
                return False
            

            if abbr[i] == word[j]:
                j += 1
            i += 1
        
        if curr_num:
            j += curr_num
        return j == len(word) 