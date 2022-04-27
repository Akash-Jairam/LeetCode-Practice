class OrderedStream {
    int ptr;
    String[] stream;
    public OrderedStream(int n) {
        this.stream = new String[n];
        this.ptr = 0;
    }
    
    public List<String> insert(int idKey, String value) {
        stream[idKey - 1] = value;
        List<String> list = new ArrayList<>();
        while(ptr < stream.length && stream[ptr] != null){
            list.add(stream[ptr]);
            ++ptr;
        }
        
        return list;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */