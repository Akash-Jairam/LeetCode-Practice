class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        d = set(dictionary)
        split = sentence.split(" ")
        res = []
        for w in split:
            added = False
            for i in range(len(w)):
                if w[:i+1] in d:
                    res.append(w[:i+1])
                    added = True
                    break
            if not added:
                res.append(w)
            
        
        return ' '.join(res)