class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        curr_num, curr_s = 0, ""
        for c in s:
            if c.isdigit():
                curr_num = curr_num * 10 + int(c)
            elif c == '[':
                stack.append((curr_num, curr_s))
                curr_num = 0
                curr_s= ""
            elif c == ']':
                prev_num, prev_s = stack.pop()
                curr_s = prev_s  + curr_s * prev_num
            else:
                curr_s += c
        
        return curr_s