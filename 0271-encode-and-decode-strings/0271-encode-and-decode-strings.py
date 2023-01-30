class Codec:
    encoded_list = []
    def encode(self, strs: List[str]) -> str:
        """Encodes a list of strings to a single string.
        """
        global encoded_list
        encoded_list = []
        for word in strs:
            curr_list = []
            for c in word:
                curr_list.append(ord(c) + 1)
            encoded_list.append(curr_list)
            
        

    def decode(self, s: str) -> List[str]:
        """Decodes a single string to a list of strings.
        """
        word_list = []
        global encoded_list
        for l in encoded_list:
            s = []
            for i in l:
                s.append(chr(i - 1))
            word_list.append(''.join(s))

        encoded_list = []
        return word_list 
        
    


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(strs))