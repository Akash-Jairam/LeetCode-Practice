from collections import deque
class BrowserHistory:

    def __init__(self, homepage: str):
        self.homepage = homepage
        self.back_page = []
        self.forward_page = deque()
        self.curr = homepage

    def visit(self, url: str) -> None:
        self.back_page.append(self.curr)
        self.forward_page = deque()
        self.curr = url

    def back(self, steps: int) -> str:
        while len(self.back_page) > 0 and steps:
            steps -= 1
            self.forward_page.appendleft(self.curr)
            self.curr = self.back_page.pop()
        return self.curr
    
    def forward(self, steps: int) -> str:
        while len(self.forward_page) > 0 and steps:
            steps -= 1
            self.back_page.append(self.curr)
            self.curr = self.forward_page.popleft()
        return self.curr

# Your BrowserHistory object will be instantiated and called as such:
# obj = BrowserHistory(homepage)
# obj.visit(url)
# param_2 = obj.back(steps)
# param_3 = obj.forward(steps)