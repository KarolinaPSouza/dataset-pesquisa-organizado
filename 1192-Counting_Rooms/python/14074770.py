from collections import deque
n, m = map(int, input().split())   # first line: n m

grid = []
for _ in range(n):
    row = input().strip()          # read each line
    grid.append(list(row))         # store as list of characters


visited = [[False]*m for _ in range(n)]
n = len(grid)
m = len(grid[0])

res = 0

def BFS(i,j):
    q = deque()
    q.append((i,j))
    visited[i][j] = True

    while q:
        i,j = q.popleft()
        for ni, nj in ((i-1,j),(i+1,j),(i,j-1),(i,j+1)):
            if 0 <= ni < n and 0 <= nj < m and grid[ni][nj] == "." and not visited[ni][nj]:
                q.append((ni,nj))
                visited[ni][nj] = True
    return 1

for i in range(n):
    for j in range(m):
        if grid[i][j] == "." and not visited[i][j]:
            res += BFS(i,j)

print(res)