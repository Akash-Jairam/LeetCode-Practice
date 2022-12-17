class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        
        for token in tokens:
            if token == '+':
                stack.append(stack.pop() + stack.pop())
            elif token == '-':
                first = stack.pop()
                stack.append(stack.pop() - first)
            elif token == '*':
                stack.append(stack.pop() * stack.pop())
            elif token == '/':
                first = stack.pop()
                stack.append((int)(stack.pop() / first))
            else:
                stack.append(int(token))
        
        return stack.pop()
                