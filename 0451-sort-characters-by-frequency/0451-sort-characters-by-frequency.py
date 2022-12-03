class Solution:
    def frequencySort(self, s: str) -> str:
        char_map = collections.Counter(s)
        
        sb = []
        for letter, freq in char_map.most_common():
            sb.append(letter * freq)
        
        
        return "".join(sb)
        