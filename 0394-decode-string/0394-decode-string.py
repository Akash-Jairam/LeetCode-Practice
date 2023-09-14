class Solution:
    def decodeString(self, s: str) -> str:
        curr_s, curr_num = "", 0
        stack = []
        
        for c in s:
            if c.isdigit():
                curr_num = curr_num * 10 + int(c)
            elif c == '[':
                stack.append((curr_s, curr_num))
                curr_s = ""
                curr_num = 0
            elif c == ']':
                prev_s, prev_num = stack.pop()
                curr_s = prev_s + curr_s * prev_num
            else:
                curr_s += c
        
        return ''.join(curr_s)