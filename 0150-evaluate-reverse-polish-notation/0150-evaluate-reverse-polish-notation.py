class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for c in tokens:
            if c == '+':
                stack.append(stack.pop() + stack.pop())
            elif c == '-':
                first = stack.pop()
                stack.append(stack.pop() - first)
            elif c == '*':
                stack.append(stack.pop() * stack.pop())
            elif c == '/':
                first = stack.pop()
                stack.append(int(stack.pop() / first))
            else:
                stack.append(int(c))
        
        
        return stack[-1]