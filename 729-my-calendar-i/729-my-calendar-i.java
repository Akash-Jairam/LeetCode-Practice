class MyCalendar {
    TreeMap<Integer, Integer> bookings = new TreeMap<>();
    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        Integer floor = bookings.floorKey(start);
        Integer ceiling = bookings.ceilingKey(start);
        
        if(floor != null && bookings.get(floor) > start) return false;
        if(ceiling != null && ceiling < end) return false;
        
        bookings.put(start, end);
        return true;
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */