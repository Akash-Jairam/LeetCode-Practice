class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        n_map = {}
        for n in arr:
            n_map[n] = 1 + n_map.get(n, 0)
        
        freq_map = set()
        
        for count in n_map.values():
            if count in freq_map:
                return False
            freq_map.add(count)
        
        return True