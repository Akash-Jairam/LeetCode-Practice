class BrowserHistory:

    def __init__(self, homepage: str):
        self.curr = homepage
        self.prev = []
        self.next = []

    def visit(self, url: str) -> None:
        self.next = []
        self.prev.append(self.curr)
        self.curr = url

    def back(self, steps: int) -> str:
        for _ in range(min(steps, len(self.prev))):
            self.next.append(self.curr)
            self.curr = self.prev.pop()
        
        return self.curr

    def forward(self, steps: int) -> str:
        for _ in range(min(steps, len(self.next))):
            self.prev.append(self.curr)
            self.curr = self.next.pop()
        
        return self.curr

# Your BrowserHistory object will be instantiated and called as such:
# obj = BrowserHistory(homepage)
# obj.visit(url)
# param_2 = obj.back(steps)
# param_3 = obj.forward(steps)