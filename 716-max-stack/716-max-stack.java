class MaxStack {

    Deque<Integer> stack;
    TreeMap<Integer, Integer> treeMap;
    public MaxStack() {
        stack = new LinkedList<Integer>();
        treeMap = new TreeMap<>();
    }
    
    public void push(int x) {
        stack.addLast(x);
        treeMap.put(x, treeMap.getOrDefault(x, 0) + 1);
    }
    
    public int pop() {
        Integer popped = stack.pollLast();
        treeMap.put(popped, treeMap.get(popped) - 1);
        if(treeMap.get(popped) == 0)
            treeMap.remove(popped);
        return popped;
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int peekMax() {
        return treeMap.lastKey();
    }
    
    public int popMax() {
        int max = treeMap.lastKey();
        stack.removeLastOccurrence(max);
        treeMap.put(max, treeMap.get(max) - 1);
        if(treeMap.get(max) == 0)
            treeMap.remove(max);
        
        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */