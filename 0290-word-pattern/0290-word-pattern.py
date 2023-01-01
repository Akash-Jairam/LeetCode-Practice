class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        word_map = {}
        strings = s.split(' ')
        if len(pattern) != len(strings):
            return False;
        
        for i in range(len(strings)):
            c = pattern[i]
            w = strings[i]

            char_key = 'char_{}'.format(c)
            char_word = 'word_{}'.format(w)
            
            if char_key not in word_map:
                word_map[char_key] = i
            
            if char_word not in word_map:
                word_map[char_word] = i 
            
            if word_map[char_key] != word_map[char_word]:
                return False
        
        return True