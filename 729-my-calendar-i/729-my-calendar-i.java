class MyCalendar {
    TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer floorKey = map.floorKey(start);
        Integer ceilingKey = map.ceilingKey(start);
        
        if(floorKey != null && start < map.get(floorKey) ) return false;
        if(ceilingKey != null && ceilingKey < end) return false;
        map.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */