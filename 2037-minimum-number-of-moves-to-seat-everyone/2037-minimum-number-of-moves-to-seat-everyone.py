class Solution:
    def minMovesToSeat(self, seats: List[int], students: List[int]) -> int:
        s1 = [0] * 101
        s2 = [0] * 101
        
        for i in range(len(seats)):
            s1[seats[i]] += 1
            s2[students[i]] += 1
        
        sort_seats, sorted_students = [], []
        for i in range(101):
            for j in range(s1[i]):
                sort_seats.append(i)
            
            for j in range(s2[i]):
                sorted_students.append(i)
        
        res = 0
        for i in range(len(seats)):
            res += abs(sort_seats[i] - sorted_students[i])
        
        return res
            