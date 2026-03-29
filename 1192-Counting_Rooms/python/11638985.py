from collections import deque
n,m= map(int,input().split())
grid=[]
for i in range(n):

    s=input()
    s=list(s)
    grid.append(s)
vis = [[0]*m for _ in range(n)]
cnt=0
for i in range(n):
    for j in range(m):
        if grid[i][j] == "#":
            pass
        else:
            if vis[i][j]!=1:
                cnt+=1
                q=deque()
                vis[i][j] = 1
                q.append((i,j))
                while q:
                    x,y = q.popleft()
                    dr = [0,0,1,-1]
                    dc = [1,-1,0,0]
                    for idx in range(4):
                        nx,ny = x+dr[idx] , y+dc[idx]
                        if 0<=nx<n  and 0<=ny<m and grid[nx][ny] == "." and vis[nx][ny]!=1:
                            vis[nx][ny] = 1
                            q.append((nx,ny))
print(cnt)
