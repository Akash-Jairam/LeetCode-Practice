class MaxStack {
    TreeMap<Integer, List<Integer>> map;
    Deque<Integer> queue;
    public MaxStack() {
        map = new TreeMap<>();
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        Deque<Integer> q = queue;
        map.putIfAbsent(x, new ArrayList<>());
        map.get(x).add(x);
        queue.offerLast(x);
    }
    
    public int pop() {
        Deque<Integer> q = queue;
        int num = queue.pollLast();
        removeFromMap(num);
        return num;
    }
    
    public int top() {
    Deque<Integer> q = queue;
        return queue.peekLast();
    }
    
    public int peekMax() {
        return map.lastKey();
    }
    
    public int popMax() {
        int num = map.lastKey();
        queue.removeLastOccurrence(num);
        removeFromMap(num);
        return num;
    }
    
    public void removeFromMap(int num){
        List<Integer> list = map.get(num);
        list.remove(Integer.valueOf(num));
        if(list.size() == 0)
            map.remove(num);
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