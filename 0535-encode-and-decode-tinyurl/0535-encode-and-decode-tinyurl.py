import random
class Codec:
    def __init__(self):
        self.hash = list('abcdefghijklmopqrstuvwxyz0123456789')
        self.map = {}
        
    def encode(self, longUrl: str) -> str:
        """Encodes a URL to a shortened URL.
        """
        temp = random.sample(self.hash, 5)
        encoded = 'http://tinyurl.com/' + ''.join(temp)
        self.map[encoded] = longUrl
        return encoded

    def decode(self, shortUrl: str) -> str:
        """Decodes a shortened URL to its original URL.
        """
        return self.map[shortUrl]
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(url))