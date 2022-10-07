class MyCalendarThree {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int max = 0;
    public MyCalendarThree() {
        
    }
    
    public int book(int start, int end) {
        map.put(start, map.floorEntry(start) != null ? map.floorEntry(start).getValue() : 0);
        map.put(end, map.floorEntry(end) != null ? map.floorEntry(end).getValue() : 0);
        for(Integer point : map.subMap(start, true, end, false).keySet()){
            map.put(point, map.get(point) + 1);
            max = Math.max(max, map.get(point));
        }
        
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */