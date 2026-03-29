from collections import deque

moves=[(0,1), (0,-1), (1,0), (-1,0)]
rooms=0

h,w=tuple(map(int, input().split()))

floor=[list(input()) for _ in range(h)]
queue=deque()

def map_room(a,b):
    queue.append((a,b))

    while queue:
        x,y=queue.popleft()
        floor[x][y]="#"
        for i,j in moves:
            if 0<=x+i<h and 0<=y+j<w and floor[x+i][y+j]==".":
                queue.append((x+i, y+j))
                floor[x+i][y+j]="#"

for i in range(h):
    for j in range(w):
        if floor[i][j]==".":
            map_room(i,j)
            rooms+=1
print(rooms)
