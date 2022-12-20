from collections import deque
class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        visited = set()
        queue = deque()
        queue.append(0)
        
        while(queue):
            size = len(queue)
            for i in range(size):
                curr_room = queue.popleft()
                visited.add(curr_room)
                for room in rooms[curr_room]:
                    if room not in visited:
                        queue.append(room)
        
        return len(visited) == len(rooms)
        