class BrowserHistory {
    Integer curr;
    HashMap<Integer, String> history;
    
    public BrowserHistory(String homepage) {
        this.curr = 1;
        history = new HashMap<>();
        history.put(curr, homepage);
    }
    
    public void visit(String url) {
        HashMap<Integer, String> map = this.history;
        int index = curr + 1;
        while(this.history.containsKey(index)){
            this.history.remove(index);
            map.remove(index);
            ++index;
        }
        ++this.curr;
        history.put(curr, url);
        
    }
    
    public String back(int steps) {
        HashMap<Integer, String> map = this.history;
        int max = this.history.size();
        if(steps >= max || curr - steps <= 1){
            this.curr = 1;
        } else{
            this.curr -= steps;
        }
        return this.history.get(curr);
    }
    
    public String forward(int steps) {
        HashMap<Integer, String> map = this.history;
        int current = this.curr;
        int max = this.history.size();
        if(steps + curr >= max){
            curr = max;
        } else{
            curr += steps;
        }
        return this.history.get(curr);

    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */