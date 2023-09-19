class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        curr = ""
        curr_num = 0
        for c in s:
            if c.isdigit():
                curr_num = curr_num * 10 + int(c)
            elif c == '[':
                stack.append((curr_num, curr))
                curr_num = 0
                curr = ""
            elif c == ']':
                prev_num, prev_s = stack.pop()
                curr = prev_s + curr * prev_num
            else:
                curr += c
        
        return curr