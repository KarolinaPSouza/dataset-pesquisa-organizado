n,m=map(int,input().split())
L=[list(input()) for _ in range(n)]

from collections import deque


cnt=0
for i in range(n):
    for j in range(m):
        if L[i][j]=='.':
            cnt+=1
            q=[(i,j)]
            while(q):
                (x,t)=q.pop()
                L[x][t]='#'
                for a,b in [(1,0),(0,1),(-1,0),(0,-1)]:
                    y,z=x+a,t+b
                    if 0<=y<n and 0<=z<m and L[y][z]=='.':
                        q.append((y,z))

print(cnt)                        