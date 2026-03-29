n, m = map(int, input().split(" "))
grid = []
for k in range(n):
    row = input()
    if len(row) != m:
        raise ValueError
    grid.append(row)

visited = [[False]*m for _ in range(n)]
def dfs(x, y):
    stack = [(x, y)]
    while stack:
        i, j = stack.pop()
        for dx, dy in [(-1,0),(1,0),(0,-1),(0,1)]:
            ni, nj = i+dx, j+dy
            if 0<=ni<n and 0<=nj<m and grid[ni][nj]=='.' and not visited[ni][nj]:
                visited[ni][nj] = True
                stack.append((ni, nj))
rooms = 0
for i in range(n):
    for j in range(m):
        if grid[i][j]=='.' and not visited[i][j]:
            visited[i][j] = True
            dfs(i, j)
            rooms += 1
print(rooms)