import sys
from collections import deque

# file = open("/Users/lucky/Interview/CSES/input.txt")
# sys.stdin = file

m, n = map(int, input().split(" "))

dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
grid = []
vis = [[False]*n for i in range(m)]

for i in range(m):
    grid.append(input())

for i in range(m):
    for j in range(n):
        if grid[i][j] == '#':
            vis[i][j] = True

def isValid(i, j):
    return 0 <= i < m and 0 <= j < n and not vis[i][j]

def bfs(i, j):
    q = deque([(i, j)])
    vis[i][j] = True
    while q:
        i, j = q.pop()

        for di, dj in dirs:
            I, J = i+di, j+dj
            if isValid(I, J):
                vis[I][J] = True
                q.appendleft((I, J))

ans = 0
for i in range(m):
    for j in range(n):
        if vis[i][j]:
            continue
        ans += 1
        bfs(i, j)

print(ans)

# file.close()