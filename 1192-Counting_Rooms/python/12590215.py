import sys
from collections import deque
sys.setrecursionlimit(10**7)

n,m=map(int,sys.stdin.readline().split())
grid=[list(sys.stdin.readline().strip()) for _ in range(n)]
visited=[[False]*m for _ in range(n)]

def bfs(x,y):
    q=deque()
    q.append((x,y))
    visited[x][y]=True
    while q:
        cx,cy=q.popleft()
        for dx,dy in [(-1,0),(1,0),(0,-1),(0,1)]:
            nx,ny=cx+dx,cy+dy
            if 0<=nx<n and 0<=ny<m and not visited[nx][ny] and grid[nx][ny]=='.':
                visited[nx][ny]=True
                q.append((nx,ny))

rooms=0
for i in range(n):
    for j in range(m):
        if grid[i][j]=='.' and not visited[i][j]:
            bfs(i,j)
            rooms+=1

print(rooms)